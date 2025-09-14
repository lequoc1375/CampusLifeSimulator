package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.entity.SubjectRegister;

import java.time.LocalDateTime;

public interface SubjectRegisterRepo extends JpaRepository<SubjectRegister, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO subject_register (subject_id, user_curriculum_id, overall, registration_time) " +
                   "VALUES (:subjectId, :userCurriculumId, 'studying', :registrationTime)", nativeQuery = true)
    int insertSubjectRegister(@Param("userCurriculumId") int userCurriculumId,
                              @Param("subjectId") int subjectId,
                              @Param("registrationTime") LocalDateTime registrationTime);
}
