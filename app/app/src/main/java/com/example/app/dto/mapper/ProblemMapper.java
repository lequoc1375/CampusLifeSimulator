package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.app.dto.requestDTO.ProblemDTORequest;
import com.example.app.dto.responseDTO.ProblemDTOResponse;
import com.example.app.entity.Problem;

@Mapper(componentModel="spring")
public interface ProblemMapper {
    Problem convertToProblem(ProblemDTORequest request);
    
    @Mapping(source="lesson.name", target="lesson_name")
    ProblemDTOResponse convertToProblemDTOResponse(Problem problem);

}
