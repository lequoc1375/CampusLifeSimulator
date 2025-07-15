package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.Food;

public interface  FoodRepo extends JpaRepository<Food, Integer> {

}
