package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.WallDTORequest;
import com.example.app.dto.responseDTO.WallDTOResponse;

public interface WallService {
    WallDTOResponse add(WallDTORequest dto);

    List<WallDTOResponse> getAll();

    WallDTOResponse update(Integer id, WallDTORequest dto);

    void delete(Integer id);
}
