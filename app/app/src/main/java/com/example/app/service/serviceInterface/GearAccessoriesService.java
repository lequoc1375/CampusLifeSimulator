package com.example.app.service.serviceInterface;

import java.util.List;
import com.example.app.dto.requestDTO.GearAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.GearAccessoriesResponseDTO;

public interface GearAccessoriesService {
    void create(GearAccessoriesRequestDTO request);

    void update(Integer id, GearAccessoriesRequestDTO request);

    void delete(Integer id);

    GearAccessoriesResponseDTO getById(Integer id);

    List<GearAccessoriesResponseDTO> getAll();
}
