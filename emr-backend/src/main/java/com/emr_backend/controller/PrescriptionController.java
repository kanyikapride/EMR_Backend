package com.emr_backend.controller;

import com.emr_backend.dto.PrescriptionRequestDTO;
import com.emr_backend.entity.Prescription;
import com.emr_backend.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
@CrossOrigin
public class PrescriptionController {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @PostMapping
    public Prescription createPrescription(@RequestBody PrescriptionRequestDTO request) {

        Prescription p = new Prescription();
        p.setPatientId(request.getPatientId());
        p.setMedicationId(request.getMedicationId());
        p.setInstructions(request.getInstructions());
        p.setDatePrescribed(LocalDate.now());

        return prescriptionRepository.save(p);
    }

    @GetMapping
    public List<Prescription> getAll() {
        return prescriptionRepository.findAll();
    }
}