package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.app.dto.requestDTO.ShopUpperClothRequestDTO;
import com.example.app.dto.responseDTO.ShopUpperClothResponseDTO;
import com.example.app.entity.ShopUpperCloth;

@Mapper(componentModel="spring")
public interface  ShopUpperClothMapper {
    
    ShopUpperCloth toEntity(ShopUpperClothRequestDTO request);

    @Mapping(source = "shop.shopId", target = "shopId")
    @Mapping(source = "upperCloth.upperId", target = "upperId")
    ShopUpperClothResponseDTO toResponse(ShopUpperCloth entity);
}
    