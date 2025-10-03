package com.example.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.app.entity.FinalExam;
import com.example.app.entity.Subject;

public interface  FinalRepo extends JpaRepository<FinalExam, Integer> {
    @Query("SELECT m FROM FinalExam m WHERE m.subject = :subject")
    List<FinalExam> findBySubject(@Param("subject") Subject subject);
}
