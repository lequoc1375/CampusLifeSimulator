package com.example.app.dto.mapper;

import org.mapstruct.*;
import com.example.app.dto.requestDTO.JobRequirementDTORequest;
import com.example.app.dto.responseDTO.JobRequirementDTOResponse;
import com.example.app.entity.*;

@Mapper(componentModel = "spring")
public interface JobRequirementMapper {

  
    default JobRequirement toJobRequirement(JobRequirementDTORequest dto, Job job, Requirements requirement) {
        JobRequirement jr = new JobRequirement();
        jr.setId(new JobRequirementId(job.getJobId(), requirement.getRequirementId()));
        jr.setJob(job);
        jr.setRequirement(requirement);
        return jr;
    }

    @Mapping(source = "job.jobId", target = "jobId")
    @Mapping(source = "requirement.requirementId", target = "requirementId")
    @Mapping(source = "job.name", target = "jobName")
    @Mapping(source = "requirement.name", target = "requirementName")
    JobRequirementDTOResponse toResponse(JobRequirement entity);
}
