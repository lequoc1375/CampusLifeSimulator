package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.app.dto.requestDTO.ShopFaceAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.ShopFaceAccessoriesResponseDTO;
import com.example.app.entity.ShopFaceAccessories;

@Mapper(componentModel="spring")
public interface ShopFaceAccessoriesMapper {
    ShopFaceAccessories toEntity(ShopFaceAccessoriesRequestDTO request);

    @Mapping(source = "shop.shopId", target = "shopId")
    @Mapping(source = "faceAccessories.faceId", target = "faceId")
    ShopFaceAccessoriesResponseDTO toResponse(ShopFaceAccessories entity);
}
