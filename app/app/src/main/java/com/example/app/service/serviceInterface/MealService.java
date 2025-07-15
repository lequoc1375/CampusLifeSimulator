package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.MealDTORequest;
import com.example.app.dto.responseDTO.MealDTOResponse;

public interface MealService {
    List<MealDTOResponse> getAll();

    MealDTOResponse getById(int id);

    void create(MealDTORequest request);

    void update(int id, MealDTORequest request);

    void delete(int id);
}
