package com.example.app.service.serviceInterface;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.entity.LessonStudying;

@Service
public interface LessonStudyingService {

    void insert(int userId, List<Integer> lessons, int subjectid);

    void updateFinishedVideo(int lessonId);
    void updateFinishedQuiz(int lessonId);
    void updateAbleNextLesson(int subjectId ,int lessonCurrentId);
    void updateNewScore(int score, int lessonId);
    boolean visitedOrNot(int lesssonId);
    void setVisited(int lessonId, boolean visited);
    List<LessonStudying> getAll();
    void save(LessonStudying ls);
}
