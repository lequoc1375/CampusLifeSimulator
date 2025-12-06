package com.example.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.GymProgress;
import com.example.app.entity.User;

public interface GymProgressRepo extends JpaRepository<GymProgress, Integer> {
    Optional<GymProgress> findByUser(User user);
}
