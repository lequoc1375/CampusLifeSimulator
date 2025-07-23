package com.example.app.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.WallMapper;
import com.example.app.dto.requestDTO.WallDTORequest;
import com.example.app.dto.responseDTO.WallDTOResponse;
import com.example.app.entity.Wall;
import com.example.app.repository.WallRepository;
import com.example.app.service.serviceInterface.WallService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WallServiceImpl implements WallService {
    @Autowired
    private WallRepository wallRepo;
    @Autowired
    private WallMapper mapper;

    @Override
    public WallDTOResponse add(WallDTORequest dto) {
        Wall wall = mapper.toEntity(dto);
        return mapper.toResponse(wallRepo.save(wall));
    }

    @Override
    public List<WallDTOResponse> getAll() {
        return wallRepo.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public WallDTOResponse update(Integer id, WallDTORequest dto) {
        Wall wall = wallRepo.findById(id).orElseThrow();
        wall.setPrice(dto.getPrice());
        wall.setImage(dto.getImage());
        return mapper.toResponse(wallRepo.save(wall));
    }

    @Override
    public void delete(Integer id) {
        wallRepo.deleteById(id);
    }
}
