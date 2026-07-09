package com.emr_backend.controller;

import com.emr_backend.dto.FinalDiagnosisDTO;
import com.emr_backend.service.DiagnosisService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/diagnosis")
@CrossOrigin
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    public DiagnosisController(
            DiagnosisService diagnosisService) {

        this.diagnosisService = diagnosisService;
    }

    @GetMapping("/{patientId}")
    public FinalDiagnosisDTO getDiagnosis(
            @PathVariable Long patientId) {

        return diagnosisService.generateDiagnosis(patientId);
    }
}