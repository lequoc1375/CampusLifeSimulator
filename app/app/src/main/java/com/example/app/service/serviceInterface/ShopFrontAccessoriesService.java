package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.ShopFrontAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.ShopFrontAccessoriesResponseDTO;

public interface ShopFrontAccessoriesService {
    void delete(int id);

    void update(int id, ShopFrontAccessoriesRequestDTO request);

    void create(ShopFrontAccessoriesRequestDTO request);

    List<ShopFrontAccessoriesResponseDTO> getAll();

    ShopFrontAccessoriesResponseDTO get(int id);
}
