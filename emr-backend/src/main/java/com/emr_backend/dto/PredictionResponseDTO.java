package com.emr_backend.dto;

import java.util.List;

public class PredictionResponseDTO {

    private List<DiseasePredictionDTO> top_predictions;

    public PredictionResponseDTO() {
    }

    public List<DiseasePredictionDTO> getTop_predictions() {
        return top_predictions;
    }

    public void setTop_predictions(List<DiseasePredictionDTO> top_predictions) {
        this.top_predictions = top_predictions;
    }
}