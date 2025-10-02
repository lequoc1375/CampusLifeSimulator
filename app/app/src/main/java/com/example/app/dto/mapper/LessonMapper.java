package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.app.dto.requestDTO.LessonDTORequest;
import com.example.app.dto.responseDTO.LessonDTOResponse;
import com.example.app.entity.Lesson;

@Mapper(componentModel="spring")
public interface LessonMapper {
    LessonMapper INSTANCE = Mappers.getMapper(LessonMapper.class);

    Lesson convertToLesson(LessonDTORequest requestLesson);

    @Mapping(source="subject.name", target="subject_name")
    LessonDTOResponse convertToLessonDTOResponse(Lesson lesson);
}
