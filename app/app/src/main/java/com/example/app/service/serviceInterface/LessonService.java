package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.LessonDTORequest;
import com.example.app.dto.responseDTO.LessonDTOResponse;

public interface LessonService {
    
    List<LessonDTOResponse> getAllLessons();

    LessonDTOResponse getLessonById(int id);

    void createLesson(LessonDTORequest request);

    void updateLesson(int id, LessonDTORequest request);

    void deleteLesson(int id);

}
