package com.example.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.app.entity.Midterm;
import com.example.app.entity.Subject;

public interface MidtermRepo extends JpaRepository<Midterm, Integer> {
    @Query("SELECT m FROM Midterm m WHERE m.subject = :subject")
    List<Midterm> findBySubject(@Param("subject") Subject subject);

}
