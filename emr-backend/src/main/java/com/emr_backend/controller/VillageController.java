package com.emr_backend.controller;


import com.emr_backend.entity.Village;
import com.emr_backend.repository.VillageRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/villages")
@CrossOrigin(origins = "*")
public class VillageController {



    private final VillageRepository repository;



    public VillageController(
            VillageRepository repository
    ){

        this.repository = repository;

    }





    @GetMapping("/ta/{taId}")
    public List<Village> getByTA(

            @PathVariable Long taId

    ){

        return repository.findByTaId(taId);

    }

}