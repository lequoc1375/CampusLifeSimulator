package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.app.dto.requestDTO.FinalDTORequest;
import com.example.app.dto.responseDTO.FinalDTOResponse;
import com.example.app.entity.FinalExam;

@Mapper(componentModel = "spring")
public interface FinalMapper {
    FinalExam convertToFinal(FinalDTORequest request);

    @Mapping(source="subject.name", target="subject_name")
    FinalDTOResponse convertToFinalDTOResponse(FinalExam finalExam);

}
