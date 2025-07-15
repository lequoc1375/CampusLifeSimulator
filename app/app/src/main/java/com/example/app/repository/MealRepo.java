package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.Meal;

public interface MealRepo extends JpaRepository<Meal, Integer> {

}
