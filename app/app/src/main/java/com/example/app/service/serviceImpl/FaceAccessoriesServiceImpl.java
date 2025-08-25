package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.app.dto.mapper.FaceAccessoriesMapper;
import com.example.app.dto.requestDTO.FaceAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.FaceAccessoriesResponseDTO;
import com.example.app.entity.FaceAccessories;
import com.example.app.repository.FaceAccessoriesRepo;
import com.example.app.service.serviceInterface.FaceAccessoriesService;

@Service
public class FaceAccessoriesServiceImpl implements FaceAccessoriesService {

    @Autowired
    private FaceAccessoriesRepo faceAccessoriesRepo;

    @Autowired
    private FaceAccessoriesMapper mapper;

    @Override
    public void create(FaceAccessoriesRequestDTO request) {
        FaceAccessories item = mapper.toEntity(request);
        faceAccessoriesRepo.save(item);
    }

    @Override
    public void update(Integer id, FaceAccessoriesRequestDTO request) {
        FaceAccessories item = faceAccessoriesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("FaceAccessories not found"));
        item.setCategories(request.getCategories());
        item.setImage(request.getImage());
        item.setName(request.getName());
        item.setPrice(request.getPrice());
        faceAccessoriesRepo.save(item);
    }

    @Override
    public void delete(Integer id) {
        faceAccessoriesRepo.deleteById(id);
    }

    @Override
    public FaceAccessoriesResponseDTO getById(Integer id) {
        FaceAccessories item = faceAccessoriesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("FaceAccessories not found"));
        return mapper.toResponseDTO(item);
    }

    @Override
    public List<FaceAccessoriesResponseDTO> getAll() {
        return faceAccessoriesRepo.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
