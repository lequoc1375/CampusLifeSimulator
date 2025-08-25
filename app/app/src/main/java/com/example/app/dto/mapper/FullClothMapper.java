package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import com.example.app.dto.requestDTO.FullClothRequestDTO;
import com.example.app.dto.responseDTO.FullClothResponseDTO;
import com.example.app.entity.FullCloth;

@Mapper(componentModel = "spring")
public interface FullClothMapper {

    FullCloth toEntity(FullClothRequestDTO dto);

    FullClothResponseDTO toResponseDTO(FullCloth cloth);
}
