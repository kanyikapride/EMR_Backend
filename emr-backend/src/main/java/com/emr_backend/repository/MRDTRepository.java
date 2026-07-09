package com.emr_backend.repository;

import com.emr_backend.entity.MRDTResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MRDTRepository extends JpaRepository<MRDTResult, Long> {

    // Get all MRDT results for a patient
    List<MRDTResult> findByPatientId(Long patientId);

    // Get the latest MRDT result
    Optional<MRDTResult> findTopByPatientIdOrderByTestDateDesc(Long patientId);
}