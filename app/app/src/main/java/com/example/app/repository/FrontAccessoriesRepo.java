package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.app.entity.FrontAccessories;

public interface FrontAccessoriesRepo extends JpaRepository<FrontAccessories, Integer> {
}
