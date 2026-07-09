package com.emr_backend.controller;

import com.emr_backend.entity.MRDTResult;
import com.emr_backend.service.MRDTService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mrdt")
@CrossOrigin
public class MRDTController {

    private final MRDTService service;

    public MRDTController(MRDTService service) {
        this.service = service;
    }

    // Save MRDT result
    @PostMapping("/save")
    public MRDTResult save(@RequestBody MRDTResult result) {
        return service.saveResult(result);
    }

    // Get MRDT history for patient
    @GetMapping("/patient/{patientId}")
    public List<MRDTResult> getByPatient(@PathVariable Long patientId) {
        return service.getByPatientId(patientId);
    }
}