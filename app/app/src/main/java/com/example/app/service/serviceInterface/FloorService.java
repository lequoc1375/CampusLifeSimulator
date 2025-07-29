package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.FloorDTORequest;
import com.example.app.dto.responseDTO.FloorDTOResponse;

public interface FloorService {

    List<FloorDTOResponse> getAll();

    FloorDTOResponse getById(int id);

    void create(FloorDTORequest request);

    void update(int id, FloorDTORequest request);

    void delete(int id);

}
