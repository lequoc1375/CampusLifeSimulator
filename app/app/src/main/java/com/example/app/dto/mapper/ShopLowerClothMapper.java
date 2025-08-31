package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.app.dto.requestDTO.ShopLowerClothRequestDTO;
import com.example.app.dto.responseDTO.ShopLowerClothResponseDTO;
import com.example.app.entity.ShopLowerCloth;

@Mapper(componentModel = "spring")
public interface ShopLowerClothMapper {

    ShopLowerCloth toEntity(ShopLowerClothRequestDTO request);

    @Mapping(source = "shop.shopId", target = "shopId")
    @Mapping(source = "lowerCloth.lowerId", target = "lowerId")
    ShopLowerClothResponseDTO toResponse(ShopLowerCloth entity);
}
