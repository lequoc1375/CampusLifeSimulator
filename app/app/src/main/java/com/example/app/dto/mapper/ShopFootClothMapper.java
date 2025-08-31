package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.app.dto.requestDTO.ShopFootClothRequestDTO;
import com.example.app.dto.responseDTO.ShopFootClothResponseDTO;
import com.example.app.entity.ShopFootCloth;

@Mapper(componentModel = "spring")
public interface ShopFootClothMapper {

    ShopFootCloth toEntity(ShopFootClothRequestDTO request);

    @Mapping(source = "shop.shopId", target = "shopId")
    @Mapping(source = "footCloth.footId", target = "footId")
    ShopFootClothResponseDTO toResponse(ShopFootCloth entity);
}
