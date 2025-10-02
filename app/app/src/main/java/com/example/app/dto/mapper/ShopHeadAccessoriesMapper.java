package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.app.dto.requestDTO.ShopHeadAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.ShopHeadAccessoriesResponseDTO;
import com.example.app.entity.ShopHeadAccessories;

@Mapper(componentModel="spring")
public interface ShopHeadAccessoriesMapper {
    ShopHeadAccessories toEntity(ShopHeadAccessoriesRequestDTO request);

    @Mapping(source = "shop.shopId", target = "shopId")
    @Mapping(source = "headAccessories.headId", target = "headId")
    ShopHeadAccessoriesResponseDTO toResponse(ShopHeadAccessories entity);
}
