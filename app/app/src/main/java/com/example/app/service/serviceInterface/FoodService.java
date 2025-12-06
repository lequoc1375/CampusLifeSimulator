package com.example.app.service.serviceInterface;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.requestDTO.FoodDTORequest;
import com.example.app.dto.responseDTO.FoodDTOResponse;

public interface FoodService {

    FoodDTOResponse create(FoodDTORequest dto, MultipartFile image) throws IOException;

    FoodDTOResponse update(Integer id, FoodDTORequest dto, MultipartFile image) throws IOException;

    void delete(Integer id) throws IOException;

    List<FoodDTOResponse> getAll();

    FoodDTOResponse getById(Integer id);

    List<FoodDTOResponse> getFoodByType(String type);
}
