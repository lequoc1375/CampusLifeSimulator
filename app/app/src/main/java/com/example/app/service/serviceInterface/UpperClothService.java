package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.UpperClothRequestDTO;
import com.example.app.dto.responseDTO.UpperClothResponseDTO;

public interface UpperClothService {
    void create(UpperClothRequestDTO request);

    void update(Integer id, UpperClothRequestDTO request);

    void delete(Integer id);

    UpperClothResponseDTO getById(Integer id);

    List<UpperClothResponseDTO> getAll();
}