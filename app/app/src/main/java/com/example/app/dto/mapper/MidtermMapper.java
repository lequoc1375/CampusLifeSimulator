package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.app.dto.requestDTO.LessonDTORequest;
import com.example.app.dto.requestDTO.MidtermDTORequest;
import com.example.app.dto.responseDTO.LessonDTOResponse;
import com.example.app.dto.responseDTO.MidtermDTOResponse;
import com.example.app.entity.Lesson;
import com.example.app.entity.Midterm;

@Mapper(componentModel="spring")
public interface MidtermMapper {

    Midterm convertToMidterm(MidtermDTORequest requestMidterm);

    @Mapping(source="subject.name", target="subject_name")
    MidtermDTOResponse convertToMidtermDTOResponse(Midterm midterm);

}
