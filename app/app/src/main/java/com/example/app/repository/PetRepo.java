package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.Pet;

public interface PetRepo extends JpaRepository<Pet, Integer> {
}
