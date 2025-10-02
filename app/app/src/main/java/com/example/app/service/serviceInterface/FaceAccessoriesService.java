package com.example.app.service.serviceInterface;

import java.util.List;
import com.example.app.dto.requestDTO.FaceAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.FaceAccessoriesResponseDTO;

public interface FaceAccessoriesService {
    void create(FaceAccessoriesRequestDTO request);

    void update(Integer id, FaceAccessoriesRequestDTO request);

    void delete(Integer id);

    FaceAccessoriesResponseDTO getById(Integer id);

    List<FaceAccessoriesResponseDTO> getAll();
}
