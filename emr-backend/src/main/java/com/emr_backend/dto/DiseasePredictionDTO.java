package com.emr_backend.dto;

public class DiseasePredictionDTO {

    private String disease;
    private double probability;

    public DiseasePredictionDTO() {
    }

    public DiseasePredictionDTO(String disease, double probability) {
        this.disease = disease;
        this.probability = probability;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }
}