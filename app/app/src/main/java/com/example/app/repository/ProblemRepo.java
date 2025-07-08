package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.Problem;

public interface ProblemRepo extends JpaRepository<Problem, Integer > {

}
