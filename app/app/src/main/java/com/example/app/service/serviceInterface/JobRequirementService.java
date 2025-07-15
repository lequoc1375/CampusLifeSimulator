package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.JobRequirementDTORequest;
import com.example.app.dto.responseDTO.JobRequirementDTOResponse;

public interface JobRequirementService {

    void add(JobRequirementDTORequest dto);

    List<JobRequirementDTOResponse> getAll();

    void delete(int jobId, int requirementId);

    void update(int oldJobId, int oldRequirementId, JobRequirementDTORequest newDTO);

    JobRequirementDTOResponse getById(int jobId, int requirementId);
}
