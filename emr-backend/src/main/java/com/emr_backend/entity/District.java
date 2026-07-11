package com.emr_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name="districts")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id=id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name=name;
    }
}