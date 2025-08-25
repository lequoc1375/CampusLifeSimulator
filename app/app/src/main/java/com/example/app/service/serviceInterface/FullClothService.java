package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.FullClothRequestDTO;
import com.example.app.dto.responseDTO.FullClothResponseDTO;

public interface FullClothService {
    void create(FullClothRequestDTO request);

    void update(Integer id, FullClothRequestDTO request);

    void delete(Integer id);

    FullClothResponseDTO getById(Integer id);

    List<FullClothResponseDTO> getAll();

}
