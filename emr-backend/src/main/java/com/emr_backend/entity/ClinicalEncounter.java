package com.emr_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clinical_encounters")
public class ClinicalEncounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Patient linked to this encounter
    @Column(nullable = false)
    private Long patientId;

    @Column(nullable = false)
    private String visitDate;

    // Comma separated symptom IDs for now
    @Column(length = 2000)
    private String symptomIds;

    @Column(length = 1000)
    private String diagnosis;

    @Column(length = 2000)
    private String treatment;

    @Column(length = 2000)
    private String notes;

    @Column(nullable = false)
    private String encounterStatus;

    public ClinicalEncounter() {
    }

    public ClinicalEncounter(
            Long patientId,
            String visitDate,
            String symptomIds,
            String diagnosis,
            String treatment,
            String notes,
            String encounterStatus) {

        this.patientId = patientId;
        this.visitDate = visitDate;
        this.symptomIds = symptomIds;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.notes = notes;
        this.encounterStatus = encounterStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getSymptomIds() {
        return symptomIds;
    }

    public void setSymptomIds(String symptomIds) {
        this.symptomIds = symptomIds;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getEncounterStatus() {
        return encounterStatus;
    }

    public void setEncounterStatus(String encounterStatus) {
        this.encounterStatus = encounterStatus;
    }
}