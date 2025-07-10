package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.app.dto.requestDTO.MidtermProblemDTORequest;
import com.example.app.dto.responseDTO.MidtermProblemDTOResponse;
import com.example.app.entity.MidtermProblem;

@Mapper(componentModel = "spring")
public interface MidtermProblemMapper {
    MidtermProblem convertToMidtermProblem(MidtermProblemDTORequest request);

    @Mapping(source = "midterm.midtermId", target = "midtermId")
    MidtermProblemDTOResponse convertToMidtermProblemDTOResponse(MidtermProblem midtermProblem);
}
