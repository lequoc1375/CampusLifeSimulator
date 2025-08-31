package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.app.dto.requestDTO.ShopFullClothRequestDTO;
import com.example.app.dto.responseDTO.ShopFullClothResponseDTO;
import com.example.app.entity.ShopFullCloth;

@Mapper(componentModel = "spring")
public interface ShopFullClothMapper {

    ShopFullCloth toEntity(ShopFullClothRequestDTO request);

    @Mapping(source = "shop.shopId", target = "shopId")
    @Mapping(source = "fullCloth.fullId", target = "fullId")
    ShopFullClothResponseDTO toResponse(ShopFullCloth entity);
}
