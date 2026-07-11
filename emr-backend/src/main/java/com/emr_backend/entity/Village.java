package com.emr_backend.entity;


import jakarta.persistence.*;


@Entity
@Table(name="villages")
public class Village {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="ta_id")
    private Long taId;


    private String name;



    public Long getId(){
        return id;
    }


    public void setId(Long id){
        this.id=id;
    }



    public Long getTaId(){
        return taId;
    }


    public void setTaId(Long taId){
        this.taId=taId;
    }



    public String getName(){
        return name;
    }


    public void setName(String name){
        this.name=name;
    }

}