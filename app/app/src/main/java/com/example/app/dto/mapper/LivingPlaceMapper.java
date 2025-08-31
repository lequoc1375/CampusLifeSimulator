package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import com.example.app.entity.LivingPlace;
import com.example.app.dto.requestDTO.LivingPlaceRequestDTO;
import com.example.app.dto.responseDTO.LivingPlaceResponseDTO;

@Mapper(componentModel = "spring")
public interface LivingPlaceMapper {
    LivingPlace toLivingPlace(LivingPlaceRequestDTO dto);

    LivingPlaceResponseDTO toLivingPlaceDTO(LivingPlace livingPlace);
}
