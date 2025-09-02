package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.ShopHeadAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.ShopHeadAccessoriesResponseDTO;

public interface ShopHeadAccessoriesService {
    void delete(int id);

    void update(int id, ShopHeadAccessoriesRequestDTO request);

    void create(ShopHeadAccessoriesRequestDTO request);

    List<ShopHeadAccessoriesResponseDTO> getAll();

    ShopHeadAccessoriesResponseDTO get(int id);
}
