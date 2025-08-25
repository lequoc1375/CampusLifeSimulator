package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.app.dto.mapper.GearAccessoriesMapper;
import com.example.app.dto.requestDTO.GearAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.GearAccessoriesResponseDTO;
import com.example.app.entity.GearAccessories;
import com.example.app.repository.GearAccessoriesRepo;
import com.example.app.service.serviceInterface.GearAccessoriesService;

@Service
public class GearAccessoriesServiceImpl implements GearAccessoriesService {

    @Autowired
    private GearAccessoriesRepo gearAccessoriesRepo;

    @Autowired
    private GearAccessoriesMapper mapper;

    @Override
    public void create(GearAccessoriesRequestDTO request) {
        GearAccessories item = mapper.toEntity(request);
        gearAccessoriesRepo.save(item);
    }

    @Override
    public void update(Integer id, GearAccessoriesRequestDTO request) {
        GearAccessories item = gearAccessoriesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("GearAccessories not found"));
        item.setCategories(request.getCategories());
        item.setImage(request.getImage());
        item.setName(request.getName());
        item.setPrice(request.getPrice());
        gearAccessoriesRepo.save(item);
    }

    @Override
    public void delete(Integer id) {
        gearAccessoriesRepo.deleteById(id);
    }

    @Override
    public GearAccessoriesResponseDTO getById(Integer id) {
        GearAccessories item = gearAccessoriesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("GearAccessories not found"));
        return mapper.toResponseDTO(item);
    }

    @Override
    public List<GearAccessoriesResponseDTO> getAll() {
        return gearAccessoriesRepo.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
