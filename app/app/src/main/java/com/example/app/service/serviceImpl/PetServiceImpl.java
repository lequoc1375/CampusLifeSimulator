package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.PetMapper;
import com.example.app.dto.requestDTO.PetDTORequest;
import com.example.app.dto.responseDTO.PetDTOResponse;
import com.example.app.entity.Pet;
import com.example.app.repository.PetRepo;
import com.example.app.service.serviceInterface.PetService;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepo petRepo;

    @Autowired
    private PetMapper petMapper;

    @Override
    public void create(PetDTORequest request) {
        petRepo.save(petMapper.toPet(request));
    }

    @Override
    public void update(int id, PetDTORequest request) {
        Pet pet = petRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        pet.setName(request.getName());
        pet.setImage(request.getImage());
        pet.setPriceBuy(request.getPriceBuy());
        pet.setPriceSell(request.getPriceSell());
        pet.setEnergyAffected(request.getEnergyAffected());
        pet.setStressAffected(request.getStressAffected());
        petRepo.save(pet);
    }

    @Override
    public void delete(int id) {
        petRepo.deleteById(id);
    }

    @Override
    public PetDTOResponse getById(int id) {
        return petMapper.toPetDTO(petRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found")));
    }

    @Override
    public List<PetDTOResponse> getAll() {
        return petRepo.findAll().stream().map(petMapper::toPetDTO).collect(Collectors.toList());
    }
}
