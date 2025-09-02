package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.ShopGearAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.ShopGearAccessoriesResponseDTO;

public interface ShopGearAccessoriesService {
    void delete(int id);

    void update(int id, ShopGearAccessoriesRequestDTO request);

    void create(ShopGearAccessoriesRequestDTO request);

    List<ShopGearAccessoriesResponseDTO> getAll();

    ShopGearAccessoriesResponseDTO get(int id);
}
