package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.LowerClothRequestDTO;
import com.example.app.dto.responseDTO.LowerClothResponseDTO;

public interface LowerClothService {
    void create(LowerClothRequestDTO request);

    void update(Integer id, LowerClothRequestDTO request);

    void delete(Integer id);

    LowerClothResponseDTO getById(Integer id);

    List<LowerClothResponseDTO> getAll();

}
