package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.ShopFullClothRequestDTO;
import com.example.app.dto.responseDTO.ShopFullClothResponseDTO;

public interface ShopFullClothService {
 
    void delete(int id);

    void update(int id, ShopFullClothRequestDTO request);

    void create(ShopFullClothRequestDTO request);

    List<ShopFullClothResponseDTO> getAll();

    ShopFullClothResponseDTO get(int id);

}
