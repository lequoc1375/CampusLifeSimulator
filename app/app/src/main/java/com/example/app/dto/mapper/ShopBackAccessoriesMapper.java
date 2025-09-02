package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.app.dto.requestDTO.ShopBackAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.ShopBackAccessoriesResponseDTO;
import com.example.app.entity.ShopBackAccessories;

@Mapper(componentModel="spring")
public interface ShopBackAccessoriesMapper {
    ShopBackAccessories toEntity(ShopBackAccessoriesRequestDTO request);

    @Mapping(source = "shop.shopId", target = "shopId")
    @Mapping(source = "backAccessories.backId", target = "backId")
    ShopBackAccessoriesResponseDTO toResponse(ShopBackAccessories entity);
}
