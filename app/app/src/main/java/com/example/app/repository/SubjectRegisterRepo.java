package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.app.entity.SubjectRegister;

public interface SubjectRegisterRepo extends JpaRepository<SubjectRegister, Integer> {

    @Query(value = "SELECT subject_register_id FROM subject_register " +
            "WHERE subject_id = :subjectId AND user_curriculum_id = :userCurriculumId", nativeQuery = true)
    Integer findIdBySubjectIdAndUserCurriculumId(@Param("subjectId") int subjectId,
            @Param("userCurriculumId") int userCurriculumId);

}
