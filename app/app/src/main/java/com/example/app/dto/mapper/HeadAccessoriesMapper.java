package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import com.example.app.dto.requestDTO.HeadAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.HeadAccessoriesResponseDTO;
import com.example.app.entity.HeadAccessories;

@Mapper(componentModel = "spring")
public interface HeadAccessoriesMapper {
    HeadAccessories toEntity(HeadAccessoriesRequestDTO dto);
    HeadAccessoriesResponseDTO toResponseDTO(HeadAccessories cloth);
}
