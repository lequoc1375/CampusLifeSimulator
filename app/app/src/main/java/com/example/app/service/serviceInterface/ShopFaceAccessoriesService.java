package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.ShopFaceAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.ShopFaceAccessoriesResponseDTO;

public interface ShopFaceAccessoriesService {
    void delete(int id);

    void update(int id, ShopFaceAccessoriesRequestDTO request);

    void create(ShopFaceAccessoriesRequestDTO request);

    List<ShopFaceAccessoriesResponseDTO> getAll();

    ShopFaceAccessoriesResponseDTO get(int id);
}
