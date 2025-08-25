package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.LowerClothMapper;
import com.example.app.dto.requestDTO.LowerClothRequestDTO;
import com.example.app.dto.responseDTO.LowerClothResponseDTO;
import com.example.app.entity.LowerCloth;
import com.example.app.repository.LowerClothRepo;
import com.example.app.service.serviceInterface.LowerClothService;

@Service
public class LowerClothServiceImpl implements LowerClothService {

    @Autowired
    private LowerClothRepo lowerClothRepo;

    @Autowired
    private LowerClothMapper mapper;

    @Override
    public void create(LowerClothRequestDTO request) {
        LowerCloth lowerCloth = mapper.toEntity(request);
        lowerClothRepo.save(lowerCloth);
    }

    @Override
    public void update(Integer id, LowerClothRequestDTO request) {
        LowerCloth lowerCloth = lowerClothRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found lowerCloth"));
        lowerCloth.setCategories(request.getCategories());
        lowerCloth.setImage(request.getImage());
        lowerCloth.setName(request.getName());
        lowerCloth.setPrice(request.getPrice());
        lowerClothRepo.save(lowerCloth);
    }

    @Override
    public void delete(Integer id) {
        lowerClothRepo.deleteById(id);
    }

    @Override
    public LowerClothResponseDTO getById(Integer id) {
        LowerCloth lowerCloth = lowerClothRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        return mapper.toResponseDTO(lowerCloth);
    }

    @Override
    public List<LowerClothResponseDTO> getAll() {
        return lowerClothRepo.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
