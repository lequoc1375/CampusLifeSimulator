package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.LivingPlaceRequestDTO;
import com.example.app.dto.responseDTO.LivingPlaceResponseDTO;

public interface LivingPlaceService {
    void create(LivingPlaceRequestDTO request);

    void update(Integer id, LivingPlaceRequestDTO request);

    void delete(Integer id);

    LivingPlaceResponseDTO getById(Integer id);

    List<LivingPlaceResponseDTO> getAll();
}
