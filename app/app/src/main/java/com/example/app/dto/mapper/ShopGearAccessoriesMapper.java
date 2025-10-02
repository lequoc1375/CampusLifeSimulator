package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.app.dto.requestDTO.ShopGearAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.ShopGearAccessoriesResponseDTO;
import com.example.app.entity.ShopGearAccessories;

@Mapper(componentModel="spring")
public interface ShopGearAccessoriesMapper {
    ShopGearAccessories toEntity(ShopGearAccessoriesRequestDTO request);

    @Mapping(source = "shop.shopId", target = "shopId")
    @Mapping(source = "gearAccessories.gearId", target = "gearId")
    ShopGearAccessoriesResponseDTO toResponse(ShopGearAccessories entity);
}
