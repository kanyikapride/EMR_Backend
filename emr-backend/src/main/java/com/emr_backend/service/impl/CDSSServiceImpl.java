package com.emr_backend.service.impl;

import com.emr_backend.dto.PredictionRequestDTO;
import com.emr_backend.dto.PredictionResponseDTO;
import com.emr_backend.service.AIService;
import com.emr_backend.service.CDSSService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CDSSServiceImpl implements CDSSService {

    private final AIService aiService;

    public CDSSServiceImpl(AIService aiService) {
        this.aiService = aiService;
    }

    @Override
    public PredictionResponseDTO analyzeSymptoms(
            List<Integer> symptoms) {

        PredictionRequestDTO request =
                new PredictionRequestDTO();

        request.setSymptoms(symptoms);

        return aiService.predictSymptoms(request);
    }
}