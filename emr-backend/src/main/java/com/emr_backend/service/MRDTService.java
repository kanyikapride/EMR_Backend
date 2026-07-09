package com.emr_backend.service;

import com.emr_backend.entity.MRDTResult;
import java.util.List;

public interface MRDTService {

    MRDTResult saveResult(MRDTResult result);

    List<MRDTResult> getByPatientId(Long patientId);
}