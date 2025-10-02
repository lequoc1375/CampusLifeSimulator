package com.example.app.dto.mapper;

import com.example.app.dto.requestDTO.MealDTORequest;
import com.example.app.dto.responseDTO.MealDTOResponse;
import com.example.app.entity.Meal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MealMapper {
    Meal toMeal(MealDTORequest request);

    MealDTOResponse toMealDTO(Meal meal);
}
