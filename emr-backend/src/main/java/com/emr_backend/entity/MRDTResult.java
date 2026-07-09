package com.emr_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mrdt_results")
public class MRDTResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;

    private Boolean result; // true = positive, false = negative

    private String parasiteLevel; // optional (low, medium, high)

    private String performedBy; // lab technician

    private LocalDateTime testDate;

    private String notes;

    public MRDTResult() {}

    public MRDTResult(Long patientId, Boolean result, String parasiteLevel,
                      String performedBy, LocalDateTime testDate, String notes) {
        this.patientId = patientId;
        this.result = result;
        this.parasiteLevel = parasiteLevel;
        this.performedBy = performedBy;
        this.testDate = testDate;
        this.notes = notes;
    }

    public Long getId() { return id; }

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public Boolean getResult() { return result; }
    public void setResult(Boolean result) { this.result = result; }

    public String getParasiteLevel() { return parasiteLevel; }
    public void setParasiteLevel(String parasiteLevel) { this.parasiteLevel = parasiteLevel; }

    public String getPerformedBy() { return performedBy; }
    public void setPerformedBy(String performedBy) { this.performedBy = performedBy; }

    public LocalDateTime getTestDate() { return testDate; }
    public void setTestDate(LocalDateTime testDate) { this.testDate = testDate; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}