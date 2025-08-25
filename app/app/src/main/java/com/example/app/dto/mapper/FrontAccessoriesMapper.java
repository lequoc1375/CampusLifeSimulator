package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import com.example.app.dto.requestDTO.FrontAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.FrontAccessoriesResponseDTO;
import com.example.app.entity.FrontAccessories;

@Mapper(componentModel = "spring")
public interface FrontAccessoriesMapper {
    FrontAccessories toEntity(FrontAccessoriesRequestDTO dto);
    FrontAccessoriesResponseDTO toResponseDTO(FrontAccessories cloth);
}
