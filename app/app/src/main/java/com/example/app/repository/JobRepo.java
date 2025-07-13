package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.Job;

public interface JobRepo extends JpaRepository<Job,Integer> {

}
