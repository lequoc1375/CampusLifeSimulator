package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.app.entity.BackAccessories;

public interface BackAccessoriesRepo extends JpaRepository<BackAccessories, Integer> {
}
