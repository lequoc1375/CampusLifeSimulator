package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.app.entity.SubjectSelectedFinal;

public interface  SubjectSelectedFinalRepo extends JpaRepository<SubjectSelectedFinal, Integer> {
 @Query("SELECT s FROM SubjectSelectedFinal s WHERE s.subjectRegister.id = :subjectRegisterId AND s.finalExam.id = :finalId")
    SubjectSelectedFinal findBySubjectRegisterIdAndFinalId(@Param("subjectRegisterId") int subjectRegisterId,
            @Param("finalId") int finalId);

    @Query("SELECT s FROM SubjectSelectedFinal s WHERE s.subjectRegister.id = :subjectRegisterId")
    SubjectSelectedFinal findBySubjectRegisterId(@Param("subjectRegisterId") Integer subjectRegisterId);
}
