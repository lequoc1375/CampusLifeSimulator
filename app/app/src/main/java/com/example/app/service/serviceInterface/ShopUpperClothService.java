package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.ShopUpperClothRequestDTO;
import com.example.app.dto.responseDTO.ShopUpperClothResponseDTO;
import com.example.app.entity.ShopUpperCloth;

public interface ShopUpperClothService {
 
    void delete(int id);

    void update(int id, ShopUpperClothRequestDTO request);

    void create(ShopUpperClothRequestDTO request);

    List<ShopUpperClothResponseDTO> getAll();

    ShopUpperClothResponseDTO get(int id);

}
