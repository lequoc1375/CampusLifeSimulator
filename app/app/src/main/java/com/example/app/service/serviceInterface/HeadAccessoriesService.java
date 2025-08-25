package com.example.app.service.serviceInterface;

import java.util.List;
import com.example.app.dto.requestDTO.HeadAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.HeadAccessoriesResponseDTO;

public interface HeadAccessoriesService {
    void create(HeadAccessoriesRequestDTO request);

    void update(Integer id, HeadAccessoriesRequestDTO request);

    void delete(Integer id);

    HeadAccessoriesResponseDTO getById(Integer id);

    List<HeadAccessoriesResponseDTO> getAll();
}
