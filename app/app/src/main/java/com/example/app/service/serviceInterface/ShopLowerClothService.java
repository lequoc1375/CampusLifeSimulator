package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.ShopLowerClothRequestDTO;
import com.example.app.dto.responseDTO.ShopLowerClothResponseDTO;

public interface ShopLowerClothService {
 
    void delete(int id);

    void update(int id, ShopLowerClothRequestDTO request);

    void create(ShopLowerClothRequestDTO request);

    List<ShopLowerClothResponseDTO> getAll();

    ShopLowerClothResponseDTO get(int id);

}
