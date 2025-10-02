package com.example.app.dto.mapper;

import org.mapstruct.Mapper;

import com.example.app.dto.requestDTO.JobDTORequest;
import com.example.app.dto.responseDTO.JobDTOResponse;
import com.example.app.entity.Job;

@Mapper(componentModel = "spring")
public interface JobMapper {
    Job toJob(JobDTORequest request);

    JobDTOResponse toJobDTO(Job job);
}
