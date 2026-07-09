package com.emr_backend.repository;

import com.emr_backend.entity.ClinicalEncounter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClinicalEncounterRepository
        extends JpaRepository<ClinicalEncounter, Long> {

    List<ClinicalEncounter> findByPatientId(Long patientId);
}