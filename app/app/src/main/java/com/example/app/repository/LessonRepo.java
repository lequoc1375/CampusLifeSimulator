package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.Lesson;

public interface LessonRepo extends JpaRepository<Lesson, Integer> {

}
