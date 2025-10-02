package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.MealMapper;
import com.example.app.dto.requestDTO.MealDTORequest;
import com.example.app.dto.responseDTO.MealDTOResponse;
import com.example.app.entity.Meal;
import com.example.app.repository.MealRepo;
import com.example.app.service.serviceInterface.MealService;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepo mealRepository;

    @Autowired
    private MealMapper mealMapper;

    @Override
    public List<MealDTOResponse> getAll() {
        return mealRepository.findAll().stream()
                .map(mealMapper::toMealDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MealDTOResponse getById(int id) {
        Meal meal = mealRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Meal not found"));
        return mealMapper.toMealDTO(meal);
    }

    @Override
    public void create(MealDTORequest request) {
        mealRepository.save(mealMapper.toMeal(request));
    }

    @Override
    public void update(int id, MealDTORequest request) {
        Meal existing = mealRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Meal not found"));
        existing.setName(request.getName());
        existing.setStartTime(request.getStartTime());
        existing.setEndTime(request.getEndTime());
        mealRepository.save(existing);
    }

    @Override
    public void delete(int id) {
        mealRepository.deleteById(id);
    }
}
