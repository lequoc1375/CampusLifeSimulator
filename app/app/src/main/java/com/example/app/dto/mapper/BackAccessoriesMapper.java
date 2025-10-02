package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import com.example.app.dto.requestDTO.BackAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.BackAccessoriesResponseDTO;
import com.example.app.entity.BackAccessories;

@Mapper(componentModel = "spring")
public interface BackAccessoriesMapper {
    BackAccessories toEntity(BackAccessoriesRequestDTO dto);
    BackAccessoriesResponseDTO toResponseDTO(BackAccessories cloth);
}
