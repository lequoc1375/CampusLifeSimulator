package com.example.app.service.serviceInterface;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.requestDTO.FoodDTORequest;
import com.example.app.dto.responseDTO.FoodDTOResponse;

public interface FoodService {
    List<FoodDTOResponse> getAll();

    FoodDTOResponse getById(int id);

    FoodDTOResponse create(FoodDTORequest request, MultipartFile image) throws IOException;

    FoodDTOResponse update(int id, FoodDTORequest request, MultipartFile image) throws IOException;

    void delete(int id);
}
