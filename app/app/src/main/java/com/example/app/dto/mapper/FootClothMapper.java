package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import com.example.app.dto.requestDTO.FootClothRequestDTO;
import com.example.app.dto.responseDTO.FootClothResponseDTO;
import com.example.app.entity.FootCloth;

@Mapper(componentModel = "spring")
public interface FootClothMapper {
    FootCloth toEntity(FootClothRequestDTO dto);
    FootClothResponseDTO toResponseDTO(FootCloth cloth);
}
