package com.emr_backend.service;

import com.emr_backend.dto.PredictionRequestDTO;
import com.emr_backend.dto.PredictionResponseDTO;

public interface AIService {

    PredictionResponseDTO predictSymptoms(PredictionRequestDTO request);
}