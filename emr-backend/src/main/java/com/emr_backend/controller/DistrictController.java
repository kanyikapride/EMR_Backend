package com.emr_backend.controller;


import com.emr_backend.entity.District;
import com.emr_backend.repository.DistrictRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/districts")
@CrossOrigin(origins = "*")
public class DistrictController {


    private final DistrictRepository districtRepository;



    public DistrictController(DistrictRepository districtRepository){

        this.districtRepository = districtRepository;

    }



    @GetMapping
    public List<District> getAllDistricts(){

        return districtRepository.findAll();

    }

}