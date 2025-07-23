package com.example.app.repository;

import com.example.app.entity.Wall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WallRepository extends JpaRepository<Wall, Integer> {
}
