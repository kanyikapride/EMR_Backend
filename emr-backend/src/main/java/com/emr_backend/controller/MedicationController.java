package com.emr_backend.controller;

import com.emr_backend.entity.Medication;
import com.emr_backend.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medications")
@CrossOrigin
public class MedicationController {

    @Autowired
    private MedicationRepository medicationRepository;

    @GetMapping
    public List<Medication> getAllMedications() {
        return medicationRepository.findAll();
    }
}