package com.emr_backend.repository;

import com.emr_backend.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Search by first name
    List<Patient> findByFirstNameContainingIgnoreCase(String firstName);

    // Search by last name
    List<Patient> findByLastNameContainingIgnoreCase(String lastName);

    // Search by phone number
    List<Patient> findByPhoneNumberContaining(String phoneNumber);

    // Search by either first name or last name
    List<Patient> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
            String firstName,
            String lastName
    );
}