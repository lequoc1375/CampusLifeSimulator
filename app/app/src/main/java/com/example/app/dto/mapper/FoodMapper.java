package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.example.app.dto.requestDTO.FoodDTORequest;
import com.example.app.dto.responseDTO.FoodDTOResponse;
import com.example.app.entity.Food;

@Mapper(componentModel="spring")
public interface FoodMapper {

    Food toEntity(FoodDTORequest dto);

    FoodDTOResponse toResponseDTO(Food food);
}
