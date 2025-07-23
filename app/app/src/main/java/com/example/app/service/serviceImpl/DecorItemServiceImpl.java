package com.example.app.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.DecorItemMapper;
import com.example.app.dto.requestDTO.DecorItemDTORequest;
import com.example.app.dto.responseDTO.DecorItemDTOResponse;
import com.example.app.entity.DecorItem;
import com.example.app.repository.DecorItemRepository;
import com.example.app.service.serviceInterface.DecorItemService;

@Service
public class DecorItemServiceImpl implements DecorItemService {

    @Autowired
    private DecorItemRepository repository;

    @Autowired
    private DecorItemMapper mapper;

    @Override
    public List<DecorItemDTOResponse> getAll() {
        return mapper.toResponseList(repository.findAll());
    }

    @Override
    public DecorItemDTOResponse getById(Integer id) {
        return mapper.toResponse(repository.findById(id).orElseThrow());
    }

    @Override
    public void create(DecorItemDTORequest dto) {
        repository.save(mapper.toEntity(dto));
    }

    @Override
    public void update(Integer id, DecorItemDTORequest dto) {
        DecorItem entity = repository.findById(id).orElseThrow();
        mapper.updateDecorItemFromDTO(dto, entity);
        repository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
