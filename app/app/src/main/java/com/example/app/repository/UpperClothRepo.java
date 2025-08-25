package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.UpperCloth;

public interface UpperClothRepo extends JpaRepository<UpperCloth, Integer> {

}
