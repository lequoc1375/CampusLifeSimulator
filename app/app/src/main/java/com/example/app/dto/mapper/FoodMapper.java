package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import com.example.app.entity.Food;
import com.example.app.dto.requestDTO.FoodDTORequest;
import com.example.app.dto.responseDTO.FoodDTOResponse;

@Mapper(componentModel = "spring")
public interface FoodMapper {
    Food toFood(FoodDTORequest request);

    FoodDTOResponse toFoodDTO(Food food);
}
