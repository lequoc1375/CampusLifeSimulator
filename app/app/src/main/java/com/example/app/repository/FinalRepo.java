package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.FinalExam;

public interface  FinalRepo extends JpaRepository<FinalExam, Integer> {

}
