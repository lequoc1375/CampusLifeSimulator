package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.app.entity.SubjectSelectedMidterm;

public interface SubjectSelectedMidtermRepo extends JpaRepository<SubjectSelectedMidterm, Integer> {

    @Query("SELECT s FROM SubjectSelectedMidterm s WHERE s.subjectRegister.id = :subjectRegisterId AND s.midterm.id = :midtermId")
    SubjectSelectedMidterm findBySubjectRegisterIdAndMidtermId(@Param("subjectRegisterId") int subjectRegisterId,
            @Param("midtermId") int midtermId);

    @Query("SELECT s FROM SubjectSelectedMidterm s WHERE s.subjectRegister.id = :subjectRegisterId")
    SubjectSelectedMidterm findBySubjectRegisterId(@Param("subjectRegisterId") Integer subjectRegisterId);

}
