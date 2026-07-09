package com.emr_backend.service.impl;

import com.emr_backend.dto.PredictionRequestDTO;
import com.emr_backend.dto.PredictionResponseDTO;
import com.emr_backend.service.AIService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AIServiceImpl implements AIService {

    private final RestTemplate restTemplate;

    // Inject from application.properties (BEST PRACTICE)
    @Value("${cdss.flask.url}")
    private String flaskUrl;

    public AIServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PredictionResponseDTO predictSymptoms(PredictionRequestDTO request) {

        return restTemplate.postForObject(
                flaskUrl,
                request,
                PredictionResponseDTO.class
        );
    }
}