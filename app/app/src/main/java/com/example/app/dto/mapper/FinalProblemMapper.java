package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.app.dto.requestDTO.FinalProblemDTORequest;
import com.example.app.dto.requestDTO.MidtermProblemDTORequest;
import com.example.app.dto.responseDTO.FinalProblemDTOResponse;
import com.example.app.dto.responseDTO.MidtermProblemDTOResponse;
import com.example.app.entity.FinalProblem;
import com.example.app.entity.MidtermProblem;

@Mapper(componentModel = "spring")
public interface FinalProblemMapper {
    
    FinalProblem convertToFinalProblem(FinalProblemDTORequest request);

    @Mapping(source="finalExam.finalId", target="finalId")
    FinalProblemDTOResponse convertToFinalProblemDTOResponse(FinalProblem finalProblem);
}
