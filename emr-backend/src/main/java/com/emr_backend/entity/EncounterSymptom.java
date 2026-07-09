package com.emr_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "encounter_symptoms")
public class EncounterSymptom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long encounterId;
    private Long symptomId;

    public EncounterSymptom() {}

    public EncounterSymptom(Long encounterId, Long symptomId) {
        this.encounterId = encounterId;
        this.symptomId = symptomId;
    }

    public Long getId() { return id; }

    public Long getEncounterId() { return encounterId; }

    public Long getSymptomId() { return symptomId; }
}