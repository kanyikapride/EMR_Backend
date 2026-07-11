package com.emr_backend.entity;


import jakarta.persistence.*;


@Entity
@Table(name="traditional_authorities")
public class TraditionalAuthority {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="district_id")
    private Long districtId;


    private String name;



    public Long getId(){
        return id;
    }


    public void setId(Long id){
        this.id=id;
    }



    public Long getDistrictId(){
        return districtId;
    }


    public void setDistrictId(Long districtId){
        this.districtId=districtId;
    }



    public String getName(){
        return name;
    }


    public void setName(String name){
        this.name=name;
    }

}