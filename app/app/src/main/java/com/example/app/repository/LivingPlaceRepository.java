package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.app.entity.LivingPlace;

@Repository
public interface LivingPlaceRepository extends JpaRepository<LivingPlace, Integer> {
}
