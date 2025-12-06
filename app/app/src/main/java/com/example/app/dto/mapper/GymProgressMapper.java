package com.example.app.dto.mapper;

import org.springframework.stereotype.Component;

import com.example.app.dto.responseDTO.GymProgressResponseDTO;
import com.example.app.entity.GymProgress;

@Component
public class GymProgressMapper {

    public GymProgressResponseDTO toResponseDTO(GymProgress p) {

        GymProgressResponseDTO dto = new GymProgressResponseDTO();

        dto.setLevel(p.getLv());
        dto.setExp(p.getExp());
        dto.setExpToNextLv(p.getExpToNextLv());

        return dto;
    }
}
