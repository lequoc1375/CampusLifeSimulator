package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.app.entity.FaceAccessories;

public interface FaceAccessoriesRepo extends JpaRepository<FaceAccessories, Integer> {
}
