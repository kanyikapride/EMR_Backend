package com.emr_backend.service;

import com.emr_backend.dto.PredictionResponseDTO;
import java.util.List;

public interface CDSSService {

    PredictionResponseDTO analyzeSymptoms(List<Integer> symptoms);
}