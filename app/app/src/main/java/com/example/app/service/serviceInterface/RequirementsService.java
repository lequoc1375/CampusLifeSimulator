package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.RequirementsDTORequest;
import com.example.app.dto.responseDTO.RequirementsDTOResponse;

public interface RequirementsService {
    List<RequirementsDTOResponse> getAll();

    RequirementsDTOResponse getById(int id);

    void create(RequirementsDTORequest request);

    void update(int id, RequirementsDTORequest request);

    void delete(int id);
}
