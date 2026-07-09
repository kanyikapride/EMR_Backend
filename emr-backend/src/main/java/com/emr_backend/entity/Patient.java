package com.emr_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // =========================
    // DEMOGRAPHICS
    // =========================

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(length = 20)
    private String gender;

    @Column(length = 20)
    private String dateOfBirth;

    @Column(length = 20)
    private String phoneNumber;

    // =========================
    // ADDRESS INFORMATION
    // =========================

    @Column(length = 100)
    private String country;

    @Column(length = 100)
    private String district;

    @Column(length = 100)
    private String traditionalAuthority;

    @Column(length = 100)
    private String village;

    // =========================
    // CONSTRUCTORS
    // =========================

    public Patient() {
    }

    public Patient(
            String firstName,
            String lastName,
            String gender,
            String dateOfBirth,
            String phoneNumber,
            String country,
            String district,
            String traditionalAuthority,
            String village) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.district = district;
        this.traditionalAuthority = traditionalAuthority;
        this.village = village;
    }

    // =========================
    // GETTERS AND SETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTraditionalAuthority() {
        return traditionalAuthority;
    }

    public void setTraditionalAuthority(String traditionalAuthority) {
        this.traditionalAuthority = traditionalAuthority;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }
}