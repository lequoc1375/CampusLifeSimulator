package com.example.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.app.entity.Problem;

public interface ProblemRepo extends JpaRepository<Problem, Integer> {
    List<Problem> findByLesson_LessonId(int lessonId);

   @Query("SELECT p FROM Problem p WHERE p.lesson.lessonId = :lessonId AND p.problem_order = :problemOrder")
    Optional<Problem> findByLesson_LessonIdAndProblem_Order(@Param("lessonId") int lessonId, @Param("problemOrder") int problemOrder);
 
}
