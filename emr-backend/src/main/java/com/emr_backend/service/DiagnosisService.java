package com.emr_backend.service;

import com.emr_backend.dto.FinalDiagnosisDTO;

public interface DiagnosisService {

    FinalDiagnosisDTO generateDiagnosis(Long patientId);
}