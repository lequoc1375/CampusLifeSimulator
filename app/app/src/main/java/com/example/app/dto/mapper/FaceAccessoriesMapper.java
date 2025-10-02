package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import com.example.app.dto.requestDTO.FaceAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.FaceAccessoriesResponseDTO;
import com.example.app.entity.FaceAccessories;

@Mapper(componentModel = "spring")
public interface FaceAccessoriesMapper {
    FaceAccessories toEntity(FaceAccessoriesRequestDTO dto);
    FaceAccessoriesResponseDTO toResponseDTO(FaceAccessories cloth);
}
