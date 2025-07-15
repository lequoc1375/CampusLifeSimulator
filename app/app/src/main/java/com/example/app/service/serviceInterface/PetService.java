package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.PetDTORequest;
import com.example.app.dto.responseDTO.PetDTOResponse;

public interface PetService {
    void create(PetDTORequest request);

    void update(int id, PetDTORequest request);

    void delete(int id);

    PetDTOResponse getById(int id);

    List<PetDTOResponse> getAll();
}
