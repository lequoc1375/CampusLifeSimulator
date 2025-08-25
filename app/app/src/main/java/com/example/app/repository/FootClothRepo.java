package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.app.entity.FootCloth;

public interface FootClothRepo extends JpaRepository<FootCloth, Integer> {
}
