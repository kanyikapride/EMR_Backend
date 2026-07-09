package com.emr_backend.controller;

import com.emr_backend.entity.ClinicalEncounter;
import com.emr_backend.repository.ClinicalEncounterRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/encounters")
@CrossOrigin(origins = "*")
public class ClinicalEncounterController {

    private final ClinicalEncounterRepository repository;

    public ClinicalEncounterController(ClinicalEncounterRepository repository) {
        this.repository = repository;
    }

    // =========================
    // CREATE ENCOUNTER (CDSS ENABLED)
    // =========================
    @PostMapping
    public ClinicalEncounter createEncounter(@RequestBody ClinicalEncounter encounter) {

        String symptomIds = encounter.getSymptomIds() != null
                ? encounter.getSymptomIds().toLowerCase()
                : "";

        // ================= CDSS LOGIC =================
        boolean fever = symptomIds.contains("1");
        boolean headache = symptomIds.contains("2");
        boolean chills = symptomIds.contains("3");
        boolean cough = symptomIds.contains("4");
        boolean chestPain = symptomIds.contains("5");
        boolean diarrhea = symptomIds.contains("6");
        boolean vomiting = symptomIds.contains("7");

        if (fever && headache && chills) {
            encounter.setDiagnosis("Malaria (CDSS Suggestion)");
            encounter.setTreatment("ACT + RDT confirmation");
        }

        else if (cough && chestPain && fever) {
            encounter.setDiagnosis("Pneumonia (CDSS Suggestion)");
            encounter.setTreatment("Antibiotics + Chest X-ray referral");
        }

        else if (diarrhea || vomiting) {
            encounter.setDiagnosis("Gastroenteritis");
            encounter.setTreatment("ORS + hydration therapy");
        }

        else if (fever && cough) {
            encounter.setDiagnosis("Respiratory infection");
            encounter.setTreatment("Symptomatic treatment + monitoring");
        }

        else {
            encounter.setDiagnosis("Further evaluation required");
            encounter.setTreatment("Refer for diagnosis");
        }

        // ================= DEFAULT STATUS =================
        if (encounter.getEncounterStatus() == null || encounter.getEncounterStatus().isBlank()) {
            encounter.setEncounterStatus("COMPLETED");
        }

        return repository.save(encounter);
    }

    // =========================
    // GET ENCOUNTERS BY PATIENT
    // =========================
    @GetMapping("/patient/{patientId}")
    public List<ClinicalEncounter> getByPatient(@PathVariable Long patientId) {
        return repository.findByPatientId(patientId);
    }

    // =========================
    // GET ALL ENCOUNTERS
    // =========================
    @GetMapping
    public List<ClinicalEncounter> getAllEncounters() {
        return repository.findAll();
    }

    // =========================
    // GET SINGLE ENCOUNTER
    // =========================
    @GetMapping("/{id}")
    public ClinicalEncounter getEncounter(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
}