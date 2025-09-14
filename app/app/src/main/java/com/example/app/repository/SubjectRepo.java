package com.example.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.app.entity.Subject;

public interface SubjectRepo extends JpaRepository<Subject, Integer> {

    @Query("SELECT s FROM Subject s WHERE s.subject_id NOT IN " +
           "(SELECT sr.subject.subject_id FROM SubjectRegister sr WHERE sr.userCurriculum.userCurriculumId = :userId)")
    List<Subject> findUnregisteredSubjectsByUserId(@Param("userId") int userId);

    @Query("SELECT s FROM Subject s JOIN SubjectRegister sr ON s.subject_id = sr.subject.subject_id " +
           "WHERE sr.userCurriculum.userCurriculumId = :userId AND sr.overall = 'studying'")
    List<Subject> findInProgressSubjectsByUserId(@Param("userId") int userId);

    @Query("SELECT s FROM Subject s JOIN SubjectRegister sr ON s.subject_id = sr.subject.subject_id " +
           "WHERE sr.userCurriculum.userCurriculumId = :userId AND sr.overall IN ('pass', 'fail')")
    List<Subject> findCompletedSubjectsByUserId(@Param("userId") int userId);
}
