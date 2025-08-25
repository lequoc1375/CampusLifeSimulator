package com.example.app.service.serviceInterface;

import java.util.List;
import com.example.app.dto.requestDTO.BackAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.BackAccessoriesResponseDTO;

public interface BackAccessoriesService {
    void create(BackAccessoriesRequestDTO request);

    void update(Integer id, BackAccessoriesRequestDTO request);

    void delete(Integer id);

    BackAccessoriesResponseDTO getById(Integer id);

    List<BackAccessoriesResponseDTO> getAll();
}
