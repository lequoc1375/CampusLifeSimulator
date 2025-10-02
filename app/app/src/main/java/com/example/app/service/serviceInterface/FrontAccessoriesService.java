package com.example.app.service.serviceInterface;

import java.util.List;
import com.example.app.dto.requestDTO.FrontAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.FrontAccessoriesResponseDTO;

public interface FrontAccessoriesService {
    void create(FrontAccessoriesRequestDTO request);

    void update(Integer id, FrontAccessoriesRequestDTO request);

    void delete(Integer id);

    FrontAccessoriesResponseDTO getById(Integer id);

    List<FrontAccessoriesResponseDTO> getAll();
}
