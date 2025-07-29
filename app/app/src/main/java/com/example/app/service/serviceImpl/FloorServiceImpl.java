package com.example.app.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.FloorMapper;
import com.example.app.dto.requestDTO.FloorDTORequest;
import com.example.app.dto.responseDTO.FloorDTOResponse;
import com.example.app.entity.Floor;
import com.example.app.repository.FloorRepo;
import com.example.app.service.serviceInterface.FloorService;

@Service
public class FloorServiceImpl implements FloorService {

    @Autowired
    private FloorRepo floorRepo;
    @Autowired
    private FloorMapper mapper;

    @Override
    public FloorDTOResponse getById(int id) {
        return mapper.toResponse(floorRepo.findById(id).orElseThrow());
    }

    @Override
    public void create(FloorDTORequest request) {
        floorRepo.save(mapper.toEntity(request));
    }

    @Override
    public void update(int id, FloorDTORequest request) {
        Floor floor = floorRepo.findById(id).orElseThrow();
        mapper.updateFloorFromDTO(request, floor);
        floorRepo.save(floor);

    }

    @Override
    public void delete(int id) {
        floorRepo.deleteById(id);
    }

    @Override
    public List<FloorDTOResponse> getAll() {
        return mapper.toResponseList(floorRepo.findAll());
    }

}
