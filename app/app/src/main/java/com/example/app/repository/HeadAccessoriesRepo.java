package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.app.entity.HeadAccessories;

public interface HeadAccessoriesRepo extends JpaRepository<HeadAccessories, Integer> {
}
