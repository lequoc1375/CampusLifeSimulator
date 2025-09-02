package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.ShopBackAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.ShopBackAccessoriesResponseDTO;

public interface ShopBackAccessoriesService {
    void delete(int id);

    void update(int id, ShopBackAccessoriesRequestDTO request);

    void create(ShopBackAccessoriesRequestDTO request);

    List<ShopBackAccessoriesResponseDTO> getAll();

    ShopBackAccessoriesResponseDTO get(int id);
}
