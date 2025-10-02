package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.FoodMapper;
import com.example.app.dto.requestDTO.FoodDTORequest;
import com.example.app.dto.responseDTO.FoodDTOResponse;
import com.example.app.entity.Food;
import com.example.app.repository.FoodRepo;
import com.example.app.service.serviceInterface.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepo foodRepository;

    @Autowired
    private FoodMapper foodMapper;

    @Override
    public List<FoodDTOResponse> getAll() {
        return foodRepository.findAll().stream()
                .map(foodMapper::toFoodDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FoodDTOResponse getById(int id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));
        return foodMapper.toFoodDTO(food);
    }

    @Override
    public void create(FoodDTORequest request) {
        Food food = foodMapper.toFood(request);
        foodRepository.save(food);
    }

    @Override
    public void update(int id, FoodDTORequest request) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));
        food.setName(request.getName());
        food.setEnergyAffected(request.getEnergyAffected());
        food.setStressAffected(request.getStressAffected());
        food.setPrice(request.getPrice());
        food.setType(request.getType());
        food.setLivingRequirement(request.getLivingRequirement());
        foodRepository.save(food);
    }

    @Override
    public void delete(int id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));
        foodRepository.delete(food);
    }
}
