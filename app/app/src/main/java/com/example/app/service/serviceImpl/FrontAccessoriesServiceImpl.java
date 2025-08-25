package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.app.dto.mapper.FrontAccessoriesMapper;
import com.example.app.dto.requestDTO.FrontAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.FrontAccessoriesResponseDTO;
import com.example.app.entity.FrontAccessories;
import com.example.app.repository.FrontAccessoriesRepo;
import com.example.app.service.serviceInterface.FrontAccessoriesService;

@Service
public class FrontAccessoriesServiceImpl implements FrontAccessoriesService {

    @Autowired
    private FrontAccessoriesRepo frontAccessoriesRepo;

    @Autowired
    private FrontAccessoriesMapper mapper;

    @Override
    public void create(FrontAccessoriesRequestDTO request) {
        FrontAccessories item = mapper.toEntity(request);
        frontAccessoriesRepo.save(item);
    }

    @Override
    public void update(Integer id, FrontAccessoriesRequestDTO request) {
        FrontAccessories item = frontAccessoriesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("FrontAccessories not found"));
        item.setCategories(request.getCategories());
        item.setImage(request.getImage());
        item.setName(request.getName());
        item.setPrice(request.getPrice());
        frontAccessoriesRepo.save(item);
    }

    @Override
    public void delete(Integer id) {
        frontAccessoriesRepo.deleteById(id);
    }

    @Override
    public FrontAccessoriesResponseDTO getById(Integer id) {
        FrontAccessories item = frontAccessoriesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("FrontAccessories not found"));
        return mapper.toResponseDTO(item);
    }

    @Override
    public List<FrontAccessoriesResponseDTO> getAll() {
        return frontAccessoriesRepo.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
