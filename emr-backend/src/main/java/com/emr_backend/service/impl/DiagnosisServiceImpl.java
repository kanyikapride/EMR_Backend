package com.emr_backend.service.impl;

import com.emr_backend.dto.FinalDiagnosisDTO;
import com.emr_backend.entity.MRDTResult;
import com.emr_backend.repository.MRDTRepository;
import com.emr_backend.service.DiagnosisService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    private final MRDTRepository mrdtRepository;

    public DiagnosisServiceImpl(MRDTRepository mrdtRepository) {
        this.mrdtRepository = mrdtRepository;
    }

    @Override
    public FinalDiagnosisDTO generateDiagnosis(Long patientId) {

        List<MRDTResult> tests =
                mrdtRepository.findByPatientId(patientId);

        if (!tests.isEmpty()) {

            MRDTResult latest =
                    tests.get(tests.size() - 1);

            // MRDT POSITIVE
            if (Boolean.TRUE.equals(latest.getResult())) {

                return new FinalDiagnosisDTO(
                        "Malaria",
                        "MRDT Positive",
                        "Start ACT treatment"
                );
            }

            // MRDT NEGATIVE
            if (Boolean.FALSE.equals(latest.getResult())) {

                return new FinalDiagnosisDTO(
                        "Alternative Diagnosis Required",
                        "MRDT Negative",
                        "Review AI predictions"
                );
            }
        }

        return new FinalDiagnosisDTO(
                "Pending Diagnosis",
                "No MRDT Result Found",
                "Review AI prediction"
        );
    }
}