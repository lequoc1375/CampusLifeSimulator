package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import com.example.app.dto.requestDTO.GearAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.GearAccessoriesResponseDTO;
import com.example.app.entity.GearAccessories;

@Mapper(componentModel = "spring")
public interface GearAccessoriesMapper {
    GearAccessories toEntity(GearAccessoriesRequestDTO dto);
    GearAccessoriesResponseDTO toResponseDTO(GearAccessories cloth);
}
