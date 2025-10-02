package com.example.app.service.serviceInterface;

import com.example.app.dto.requestDTO.DecorItemDTORequest;
import com.example.app.dto.responseDTO.DecorItemDTOResponse;

import java.util.List;

public interface DecorItemService {
    List<DecorItemDTOResponse> getAll();

    DecorItemDTOResponse getById(Integer id);

    void create(DecorItemDTORequest dto);

    void update(Integer id, DecorItemDTORequest dto);

    void delete(Integer id);
}
