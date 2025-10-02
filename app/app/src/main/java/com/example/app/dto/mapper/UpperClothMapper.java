package com.example.app.dto.mapper;

import org.mapstruct.Mapper;

import com.example.app.dto.requestDTO.UpperClothRequestDTO;
import com.example.app.dto.responseDTO.UpperClothResponseDTO;
import com.example.app.entity.UpperCloth;

@Mapper(componentModel="spring")
public interface  UpperClothMapper {

    UpperCloth toEntity(UpperClothRequestDTO dto);

    UpperClothResponseDTO toResponseDTO(UpperCloth cloth);
}
