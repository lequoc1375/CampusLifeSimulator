package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.app.dto.mapper.BackAccessoriesMapper;
import com.example.app.dto.requestDTO.BackAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.BackAccessoriesResponseDTO;
import com.example.app.entity.BackAccessories;
import com.example.app.repository.BackAccessoriesRepo;
import com.example.app.service.serviceInterface.BackAccessoriesService;

@Service
public class BackAccessoriesServiceImpl implements BackAccessoriesService {

    @Autowired
    private BackAccessoriesRepo backAccessoriesRepo;

    @Autowired
    private BackAccessoriesMapper mapper;

    @Override
    public void create(BackAccessoriesRequestDTO request) {
        BackAccessories item = mapper.toEntity(request);
        backAccessoriesRepo.save(item);
    }

    @Override
    public void update(Integer id, BackAccessoriesRequestDTO request) {
        BackAccessories item = backAccessoriesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("BackAccessories not found"));
        item.setCategories(request.getCategories());
        item.setImage(request.getImage());
        item.setName(request.getName());
        item.setPrice(request.getPrice());
        backAccessoriesRepo.save(item);
    }

    @Override
    public void delete(Integer id) {
        backAccessoriesRepo.deleteById(id);
    }

    @Override
    public BackAccessoriesResponseDTO getById(Integer id) {
        BackAccessories item = backAccessoriesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("BackAccessories not found"));
        return mapper.toResponseDTO(item);
    }

    @Override
    public List<BackAccessoriesResponseDTO> getAll() {
        return backAccessoriesRepo.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
