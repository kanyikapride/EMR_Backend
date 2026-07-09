package com.emr_backend.controller;

import com.emr_backend.entity.Symptom;
import com.emr_backend.repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/symptoms")
@CrossOrigin
public class SymptomController {

    @Autowired
    private SymptomRepository symptomRepository;

    @GetMapping
    public List<Symptom> getAllSymptoms() {
        return symptomRepository.findAll();
    }
}