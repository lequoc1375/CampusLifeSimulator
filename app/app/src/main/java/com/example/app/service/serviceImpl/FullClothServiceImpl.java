package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.FullClothMapper;
import com.example.app.dto.requestDTO.FullClothRequestDTO;
import com.example.app.dto.responseDTO.FullClothResponseDTO;
import com.example.app.entity.FullCloth;
import com.example.app.repository.FullClothRepo;
import com.example.app.service.serviceInterface.FullClothService;

@Service
public class FullClothServiceImpl implements FullClothService {

    @Autowired
    private FullClothRepo fullClothRepo;

    @Autowired
    private FullClothMapper mapper;

    @Override
    public void create(FullClothRequestDTO request) {
        FullCloth cloth = mapper.toEntity(request);
        fullClothRepo.save(cloth);
    }

    @Override
    public void update(Integer id, FullClothRequestDTO request) {
        FullCloth cloth = fullClothRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("FullCloth not found"));
        cloth.setCategories(request.getCategories());
        cloth.setImage(request.getImage());
        cloth.setName(request.getName());
        cloth.setPrice(request.getPrice());
        fullClothRepo.save(cloth);
    }

    @Override
    public void delete(Integer id) {
        fullClothRepo.deleteById(id);
    }

    @Override
    public FullClothResponseDTO getById(Integer id) {
        FullCloth cloth = fullClothRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("FullCloth not found"));
        return mapper.toResponseDTO(cloth);
    }

    @Override
    public List<FullClothResponseDTO> getAll() {
        return fullClothRepo.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
