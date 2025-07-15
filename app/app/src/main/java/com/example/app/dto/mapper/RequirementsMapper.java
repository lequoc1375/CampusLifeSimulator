package com.example.app.dto.mapper;

import org.mapstruct.Mapper;

import com.example.app.dto.requestDTO.RequirementsDTORequest;
import com.example.app.dto.responseDTO.RequirementsDTOResponse;
import com.example.app.entity.Requirements;

@Mapper(componentModel = "spring")
public interface RequirementsMapper {
    Requirements toRequirements(RequirementsDTORequest request);

    RequirementsDTOResponse toRequirementDTO(Requirements requirements);
}
