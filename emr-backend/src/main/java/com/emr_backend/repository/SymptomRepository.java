package com.emr_backend.repository;

import com.emr_backend.entity.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SymptomRepository extends JpaRepository<Symptom, Long> {

    List<Symptom> findByNameContainingIgnoreCase(String name);
}