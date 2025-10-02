package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.app.dto.requestDTO.ShopFrontAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.ShopFrontAccessoriesResponseDTO;
import com.example.app.entity.ShopFrontAccessories;

@Mapper(componentModel="spring")
public interface ShopFrontAccessoriesMapper {
    ShopFrontAccessories toEntity(ShopFrontAccessoriesRequestDTO request);

    @Mapping(source = "shop.shopId", target = "shopId")
    @Mapping(source = "frontAccessories.frontId", target = "frontId")
    ShopFrontAccessoriesResponseDTO toResponse(ShopFrontAccessories entity);
}
