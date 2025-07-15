package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.JobDTORequest;
import com.example.app.dto.responseDTO.JobDTOResponse;

public interface JobService {
    List<JobDTOResponse> getAllJobs();

    JobDTOResponse getJobById(int id);

    void createJob(JobDTORequest request);

    void updateJob(int id, JobDTORequest request);

    void deleteJob(int id);
}
