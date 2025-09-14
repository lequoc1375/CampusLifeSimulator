package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.Subject;

public interface SubjectRepo extends JpaRepository<Subject, Integer> {

}
