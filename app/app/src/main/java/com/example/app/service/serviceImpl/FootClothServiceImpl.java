package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.app.dto.mapper.FootClothMapper;
import com.example.app.dto.requestDTO.FootClothRequestDTO;
import com.example.app.dto.responseDTO.FootClothResponseDTO;
import com.example.app.entity.FootCloth;
import com.example.app.repository.FootClothRepo;
import com.example.app.service.serviceInterface.FootClothService;

@Service
public class FootClothServiceImpl implements FootClothService {

    @Autowired
    private FootClothRepo footClothRepo;

    @Autowired
    private FootClothMapper mapper;

    @Override
    public void create(FootClothRequestDTO request) {
        FootCloth cloth = mapper.toEntity(request);
        footClothRepo.save(cloth);
    }

    @Override
    public void update(Integer id, FootClothRequestDTO request) {
        FootCloth cloth = footClothRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("FootCloth not found"));
        cloth.setCategories(request.getCategories());
        cloth.setImage(request.getImage());
        cloth.setName(request.getName());
        cloth.setPrice(request.getPrice());
        footClothRepo.save(cloth);
    }

    @Override
    public void delete(Integer id) {
        footClothRepo.deleteById(id);
    }

    @Override
    public FootClothResponseDTO getById(Integer id) {
        FootCloth cloth = footClothRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("FootCloth not found"));
        return mapper.toResponseDTO(cloth);
    }

    @Override
    public List<FootClothResponseDTO> getAll() {
        return footClothRepo.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
