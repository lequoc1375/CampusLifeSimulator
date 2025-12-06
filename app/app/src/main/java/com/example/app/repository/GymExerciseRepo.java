package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.app.entity.GymExercise;

public interface GymExerciseRepo extends JpaRepository<GymExercise, Integer> {
}
