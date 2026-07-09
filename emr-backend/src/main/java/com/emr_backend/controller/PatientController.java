package com.emr_backend.controller;

import com.emr_backend.entity.Patient;
import com.emr_backend.repository.PatientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "*")
public class PatientController {

    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // =========================
    // GET ALL PATIENTS
    // =========================
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // =========================
    // GET PATIENT BY ID
    // =========================
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {

        return patientRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // =========================
    // SEARCH PATIENTS
    // Example:
    // /api/patients/search?name=john
    // =========================
    @GetMapping("/search")
    public List<Patient> searchPatients(@RequestParam String name) {

        return patientRepository
                .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
                        name,
                        name
                );
    }

    // =========================
    // CREATE PATIENT
    // =========================
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {

        return patientRepository.save(patient);
    }

    // =========================
    // UPDATE PATIENT
    // =========================
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(
            @PathVariable Long id,
            @RequestBody Patient updatedPatient) {

        return patientRepository.findById(id)
                .map(patient -> {

                    // Basic Details
                    patient.setFirstName(updatedPatient.getFirstName());
                    patient.setLastName(updatedPatient.getLastName());
                    patient.setGender(updatedPatient.getGender());
                    patient.setDateOfBirth(updatedPatient.getDateOfBirth());
                    patient.setPhoneNumber(updatedPatient.getPhoneNumber());

                    // Address Details
                    patient.setCountry(updatedPatient.getCountry());
                    patient.setDistrict(updatedPatient.getDistrict());
                    patient.setTraditionalAuthority(
                            updatedPatient.getTraditionalAuthority()
                    );
                    patient.setVillage(updatedPatient.getVillage());

                    Patient savedPatient = patientRepository.save(patient);

                    return ResponseEntity.ok(savedPatient);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // =========================
    // DELETE PATIENT
    // =========================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {

        if (!patientRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        patientRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}