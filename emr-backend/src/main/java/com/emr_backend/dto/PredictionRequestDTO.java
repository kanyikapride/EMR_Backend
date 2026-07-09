package com.emr_backend.dto;

import java.util.List;

public class PredictionRequestDTO {

    private List<Integer> symptoms;

    public PredictionRequestDTO() {
    }

    public List<Integer> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Integer> symptoms) {
        this.symptoms = symptoms;
    }
}