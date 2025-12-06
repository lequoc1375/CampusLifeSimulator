package com.example.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.Food;

public interface  FoodRepo extends JpaRepository<Food, Integer> {
    public Food findByFoodId(Integer foodId);
}
