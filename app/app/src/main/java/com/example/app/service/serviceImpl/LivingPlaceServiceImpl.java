package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.LivingPlaceMapper;
import com.example.app.dto.requestDTO.LivingPlaceRequestDTO;
import com.example.app.dto.responseDTO.LivingPlaceResponseDTO;
import com.example.app.entity.LivingPlace;
import com.example.app.repository.LivingPlaceRepository;
import com.example.app.service.serviceInterface.LivingPlaceService;

@Service
public class LivingPlaceServiceImpl implements LivingPlaceService {

    @Autowired
    private LivingPlaceRepository livingPlaceRepository;

    @Autowired
    private LivingPlaceMapper livingPlaceMapper;

    @Override
    public void create(LivingPlaceRequestDTO request) {
        LivingPlace livingPlace = livingPlaceMapper.toLivingPlace(request);
        livingPlaceRepository.save(livingPlace);
    }

    @Override
    public void update(Integer id, LivingPlaceRequestDTO request) {
        LivingPlace existing = livingPlaceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("LivingPlace not found with id: " + id));
        LivingPlace updated = livingPlaceMapper.toLivingPlace(request);
        updated.setPlaceId(existing.getPlaceId()); 
        livingPlaceRepository.save(updated);
    }

    @Override
    public void delete(Integer id) {
        livingPlaceRepository.deleteById(id);
    }

    @Override
    public LivingPlaceResponseDTO getById(Integer id) {
        LivingPlace livingPlace = livingPlaceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("LivingPlace not found with id: " + id));
        return livingPlaceMapper.toLivingPlaceDTO(livingPlace);
    }

    @Override
    public List<LivingPlaceResponseDTO> getAll() {
        return livingPlaceRepository.findAll()
                .stream()
                .map(livingPlaceMapper::toLivingPlaceDTO)
                .collect(Collectors.toList());
    }
}
