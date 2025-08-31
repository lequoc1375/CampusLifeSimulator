package com.example.app.dto.mapper;

import org.mapstruct.Mapper;

import com.example.app.dto.requestDTO.ShopRequestDTO;
import com.example.app.dto.responseDTO.ShopResponseDTO;
import com.example.app.entity.Shop;

@Mapper(componentModel = "spring")
public interface ShopMapper {
    Shop toEntity(ShopRequestDTO requestDTO);

    ShopResponseDTO toResponseDTO(Shop shop);
    
}
