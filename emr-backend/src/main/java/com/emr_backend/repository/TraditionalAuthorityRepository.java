package com.emr_backend.repository;

import com.emr_backend.entity.TraditionalAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TraditionalAuthorityRepository
        extends JpaRepository<TraditionalAuthority, Long> {


    List<TraditionalAuthority> findByDistrictId(Long districtId);

}