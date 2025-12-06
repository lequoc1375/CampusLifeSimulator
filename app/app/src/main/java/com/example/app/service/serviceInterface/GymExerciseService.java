package com.example.app.service.serviceInterface;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.requestDTO.GymExerciseDTORequest;
import com.example.app.dto.responseDTO.GymExerciseDTOResponse;

public interface GymExerciseService {
    GymExerciseDTOResponse create(GymExerciseDTORequest dto, MultipartFile image) throws IOException;
    GymExerciseDTOResponse update(Integer id, GymExerciseDTORequest dto, MultipartFile image) throws IOException;
    void delete(Integer id) throws IOException;
    List<GymExerciseDTOResponse> getAll();
    GymExerciseDTOResponse getById(Integer id);
}

