package com.emr_backend.controller;


import com.emr_backend.entity.TraditionalAuthority;
import com.emr_backend.repository.TraditionalAuthorityRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/traditional-authorities")
@CrossOrigin(origins = "*")
public class TraditionalAuthorityController {



    private final TraditionalAuthorityRepository repository;



    public TraditionalAuthorityController(
            TraditionalAuthorityRepository repository
    ){

        this.repository = repository;

    }




    @GetMapping("/district/{districtId}")
    public List<TraditionalAuthority> getByDistrict(

            @PathVariable Long districtId

    ){

        return repository.findByDistrictId(districtId);

    }

}