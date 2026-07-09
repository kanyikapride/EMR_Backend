package com.emr_backend.service.impl;

import com.emr_backend.entity.MRDTResult;
import com.emr_backend.repository.MRDTRepository;
import com.emr_backend.service.MRDTService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MRDTServiceImpl implements MRDTService {

    private final MRDTRepository repository;

    public MRDTServiceImpl(MRDTRepository repository) {
        this.repository = repository;
    }

    @Override
    public MRDTResult saveResult(MRDTResult result) {

        if (result.getTestDate() == null) {
            result.setTestDate(LocalDateTime.now());
        }

        return repository.save(result);
    }

    @Override
    public List<MRDTResult> getByPatientId(Long patientId) {
        return repository.findByPatientId(patientId);
    }
}