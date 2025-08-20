package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.app.entity.Floor;
public interface FloorRepo extends JpaRepository<Floor, Integer> {

}
