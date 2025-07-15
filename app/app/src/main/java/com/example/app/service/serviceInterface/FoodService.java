package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.FoodDTORequest;
import com.example.app.dto.responseDTO.FoodDTOResponse;

public interface FoodService {
    List<FoodDTOResponse> getAll();

    FoodDTOResponse getById(int id);

    void create(FoodDTORequest request);

    void update(int id, FoodDTORequest request);

    void delete(int id);
}
