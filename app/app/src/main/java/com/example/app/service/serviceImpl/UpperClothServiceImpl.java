package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.UpperClothMapper;
import com.example.app.dto.requestDTO.UpperClothRequestDTO;
import com.example.app.dto.responseDTO.UpperClothResponseDTO;
import com.example.app.entity.UpperCloth;
import com.example.app.repository.UpperClothRepo;
import com.example.app.service.serviceInterface.UpperClothService;

@Service
public class UpperClothServiceImpl implements UpperClothService {

    @Autowired
    private UpperClothRepo upperClothRepo;


    @Autowired
    private UpperClothMapper mapper;

    @Override
    public void create(UpperClothRequestDTO request) {
        UpperCloth upperCloth = mapper.toEntity(request);
        upperClothRepo.save(upperCloth);
    }

    @Override
    public void update(Integer id, UpperClothRequestDTO request) {
        UpperCloth upperCloth = upperClothRepo.findById(id).orElseThrow(()-> new RuntimeException("Not found upperCloth"));
        upperCloth.setCategories(request.getCategories());
        upperCloth.setImage(request.getImage());
        upperCloth.setName(request.getName());
        upperCloth.setPrice(request.getPrice());
        upperClothRepo.save(upperCloth);
    }

    @Override
    public void delete(Integer id) {
        upperClothRepo.deleteById(id);
    }

    @Override
    public UpperClothResponseDTO getById(Integer id) {
        UpperCloth upperCloth = upperClothRepo.findById(id).orElseThrow(()-> new RuntimeException("Not found"));
        return mapper.toResponseDTO(upperCloth); 
    }

    @Override
    public List<UpperClothResponseDTO> getAll() {
        return upperClothRepo.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

}
