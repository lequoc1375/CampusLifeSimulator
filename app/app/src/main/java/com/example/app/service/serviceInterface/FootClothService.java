package com.example.app.service.serviceInterface;

import java.util.List;
import com.example.app.dto.requestDTO.FootClothRequestDTO;
import com.example.app.dto.responseDTO.FootClothResponseDTO;

public interface FootClothService {
    void create(FootClothRequestDTO request);

    void update(Integer id, FootClothRequestDTO request);

    void delete(Integer id);

    FootClothResponseDTO getById(Integer id);

    List<FootClothResponseDTO> getAll();
}
