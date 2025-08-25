package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.app.dto.mapper.HeadAccessoriesMapper;
import com.example.app.dto.requestDTO.HeadAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.HeadAccessoriesResponseDTO;
import com.example.app.entity.HeadAccessories;
import com.example.app.repository.HeadAccessoriesRepo;
import com.example.app.service.serviceInterface.HeadAccessoriesService;

@Service
public class HeadAccessoriesServiceImpl implements HeadAccessoriesService {

    @Autowired
    private HeadAccessoriesRepo headAccessoriesRepo;

    @Autowired
    private HeadAccessoriesMapper mapper;

    @Override
    public void create(HeadAccessoriesRequestDTO request) {
        HeadAccessories item = mapper.toEntity(request);
        headAccessoriesRepo.save(item);
    }

    @Override
    public void update(Integer id, HeadAccessoriesRequestDTO request) {
        HeadAccessories item = headAccessoriesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("HeadAccessories not found"));
        item.setCategories(request.getCategories());
        item.setImage(request.getImage());
        item.setName(request.getName());
        item.setPrice(request.getPrice());
        headAccessoriesRepo.save(item);
    }

    @Override
    public void delete(Integer id) {
        headAccessoriesRepo.deleteById(id);
    }

    @Override
    public HeadAccessoriesResponseDTO getById(Integer id) {
        HeadAccessories item = headAccessoriesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("HeadAccessories not found"));
        return mapper.toResponseDTO(item);
    }

    @Override
    public List<HeadAccessoriesResponseDTO> getAll() {
        return headAccessoriesRepo.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
