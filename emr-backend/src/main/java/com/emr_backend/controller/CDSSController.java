package com.emr_backend.controller;

import com.emr_backend.dto.PredictionRequestDTO;
import com.emr_backend.dto.PredictionResponseDTO;
import com.emr_backend.service.CDSSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cdss")
@CrossOrigin
public class CDSSController {

    @Autowired
    private CDSSService cdssService;

    @PostMapping("/analyze")
    public PredictionResponseDTO analyze(@RequestBody PredictionRequestDTO request) {

        return cdssService.analyzeSymptoms(request.getSymptoms());
    }
}