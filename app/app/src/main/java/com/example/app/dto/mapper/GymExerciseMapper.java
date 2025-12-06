package com.example.app.dto.mapper;

import org.springframework.stereotype.Component;

import com.example.app.dto.requestDTO.GymExerciseDTORequest;
import com.example.app.dto.responseDTO.GymExerciseDTOResponse;
import com.example.app.entity.GymExercise;

@Component
public class GymExerciseMapper {

    public GymExercise toEntity(GymExerciseDTORequest dto) {
        GymExercise e = new GymExercise();
        e.setName(dto.getName());
        e.setEnergyCost(dto.getEnergyCost());
        e.setStressIncrease(dto.getStressIncrease());
        e.setExpReward(dto.getExpReward());
        e.setMinLevel(dto.getMinLevel());
        return e;
    }

    public GymExerciseDTOResponse toResponseDTO(GymExercise e) {
        GymExerciseDTOResponse dto = new GymExerciseDTOResponse();
        dto.setGymExerciseId(e.getGymExerciseId());
        dto.setName(e.getName());
        dto.setEnergyCost(e.getEnergyCost());
        dto.setStressIncrease(e.getStressIncrease());
        dto.setExpReward(e.getExpReward());
        dto.setMinLevel(e.getMinLevel());
        dto.setImageUrl(e.getImageUrl());
        return dto;
    }
}


