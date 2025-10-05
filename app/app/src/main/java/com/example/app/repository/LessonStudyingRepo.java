package com.example.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.app.entity.LessonStudying;

public interface LessonStudyingRepo extends JpaRepository<LessonStudying, Integer> {

        @Query(value = "SELECT * FROM lesson_studying WHERE lesson_id = :lessonId", nativeQuery = true)
        Optional<LessonStudying> findByLessonId(@Param("lessonId") int lessonId);

        @Query(value = "SELECT ls.lesson_id FROM lesson_studying ls " +
                        "JOIN lesson l ON ls.lesson_id = l.lesson_id " +
                        "WHERE l.subject_id = :subjectId " +
                        "AND l.lesson_order = :currentOrder + 1", nativeQuery = true)
        Optional<Integer> findNextLessonStudyingBySubjectIdAndCurrentOrder(
                        @Param("subjectId") int subjectId,
                        @Param("currentOrder") int currentOrder);

        @Query("SELECT COUNT(l) > 0 FROM LessonStudying l " +
                        "WHERE l.subjectRegister.subject_register_id = :subjectRegisterId " +
                        "AND l.studyStatus = 'unfinished'")
        boolean existsUnFinishedLessons(@Param("subjectRegisterId") Integer subjectRegisterId);

}
