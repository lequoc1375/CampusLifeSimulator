package com.example.app.dto.mapper;

import org.mapstruct.Mapper;

import com.example.app.dto.requestDTO.LowerClothRequestDTO;
import com.example.app.dto.responseDTO.LowerClothResponseDTO;
import com.example.app.entity.LowerCloth;


@Mapper(componentModel="spring")
public interface  LowerClothMapper {

    LowerCloth toEntity(LowerClothRequestDTO dto);

    LowerClothResponseDTO toResponseDTO(LowerCloth cloth);
}
