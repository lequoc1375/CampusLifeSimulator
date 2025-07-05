package com.example.app.dto.mapper;

import org.mapstruct.Mapper;

import com.example.app.dto.requestDTO.LessonDTORequest;
import com.example.app.dto.requestDTO.SubjectDTORequest;
import com.example.app.dto.responseDTO.LessonDTOResponse;
import com.example.app.dto.responseDTO.SubjectDTOResponse;
import com.example.app.entity.Subject;

@Mapper(componentModel="spring")
public interface SubjectMapper {
    Subject convertToSubject(SubjectDTORequest requestSubject);

    SubjectDTOResponse convertToSubjectDTOResponse(Subject subject);
}
