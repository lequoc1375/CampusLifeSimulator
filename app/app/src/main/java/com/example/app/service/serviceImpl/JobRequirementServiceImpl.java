package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.JobRequirementMapper;
import com.example.app.dto.requestDTO.JobRequirementDTORequest;
import com.example.app.dto.responseDTO.JobRequirementDTOResponse;
import com.example.app.entity.Job;
import com.example.app.entity.Requirements;
import com.example.app.entity.JobRequirement;
import com.example.app.entity.JobRequirementId;
import com.example.app.repository.JobRepo;
import com.example.app.repository.RequirementsRepo;
import com.example.app.repository.JobRequirementRepo;
import com.example.app.service.serviceInterface.JobRequirementService;

@Service
public class JobRequirementServiceImpl implements JobRequirementService {

    @Autowired
    private JobRequirementRepo jobRequirementRepo;

    @Autowired
    private JobRepo jobRepo;

    @Autowired
    private RequirementsRepo requirementsRepo;

    @Autowired
    private JobRequirementMapper jobRequirementMapper;

    @Override
    public void add(JobRequirementDTORequest dto) {
        Job job = jobRepo.findById(dto.getJobId())
                .orElseThrow(() -> new RuntimeException("Job not found"));
        Requirements requirement = requirementsRepo.findById(dto.getRequirementId())
                .orElseThrow(() -> new RuntimeException("Requirement not found"));

        JobRequirement jr = new JobRequirement(job, requirement);
        jobRequirementRepo.save(jr);
    }

    @Override
    public List<JobRequirementDTOResponse> getAll() {
        return jobRequirementRepo.findAll().stream()
                .map(jobRequirementMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int jobId, int requirementId) {
        JobRequirementId id = new JobRequirementId(jobId, requirementId);
        if (!jobRequirementRepo.existsById(id)) {
            throw new RuntimeException("JobRequirement not found for delete");
        }
        jobRequirementRepo.deleteById(id);
    }

    @Override
    public void update(int oldJobId, int oldRequirementId, JobRequirementDTORequest newDTO) {
        JobRequirementId oldId = new JobRequirementId(oldJobId, oldRequirementId);

        JobRequirement existing = jobRequirementRepo.findById(oldId)
                .orElseThrow(() -> new RuntimeException("JobRequirement not found for update"));

        jobRequirementRepo.delete(existing); // delete old

        Job newJob = jobRepo.findById(newDTO.getJobId())
                .orElseThrow(() -> new RuntimeException("New Job not found"));
        Requirements newReq = requirementsRepo.findById(newDTO.getRequirementId())
                .orElseThrow(() -> new RuntimeException("New Requirement not found"));

        JobRequirement updated = new JobRequirement(newJob, newReq);
        jobRequirementRepo.save(updated);
    }

    @Override
    public JobRequirementDTOResponse getById(int jobId, int requirementId) {
        JobRequirement jr = jobRequirementRepo.findById(new JobRequirementId(jobId, requirementId))
                .orElseThrow(() -> new RuntimeException("JobRequirement not found"));
        return jobRequirementMapper.toResponse(jr);
    }
}
