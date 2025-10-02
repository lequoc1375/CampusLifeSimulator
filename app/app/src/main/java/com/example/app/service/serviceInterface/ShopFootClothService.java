package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.ShopFootClothRequestDTO;
import com.example.app.dto.responseDTO.ShopFootClothResponseDTO;

public interface ShopFootClothService {
 
    void delete(int id);

    void update(int id, ShopFootClothRequestDTO request);

    void create(ShopFootClothRequestDTO request);

    List<ShopFootClothResponseDTO> getAll();

    ShopFootClothResponseDTO get(int id);

}
