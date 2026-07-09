package com.emr_backend.dto;

public class FinalDiagnosisDTO {

    private String diagnosis;
    private String reason;
    private String recommendation;

    public FinalDiagnosisDTO() {
    }

    public FinalDiagnosisDTO(
            String diagnosis,
            String reason,
            String recommendation) {

        this.diagnosis = diagnosis;
        this.reason = reason;
        this.recommendation = recommendation;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}