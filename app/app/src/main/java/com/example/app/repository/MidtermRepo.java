package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.Midterm;

public interface MidtermRepo extends JpaRepository<Midterm, Integer>  {

}
