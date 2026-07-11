package com.emr_backend.repository;

import com.emr_backend.entity.Village;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VillageRepository extends JpaRepository<Village, Long> {


    List<Village> findByTaId(Long taId);

}