package com.example.app.service.serviceInterface;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface LessonStudyingService {

    void insert(int userId, List<Integer> lessons, int subjectid);

    void updateFinishedVideo(int lessonId);
    void updateFinishedQuiz(int lessonId);
    void updateAbleNextLesson(int subjectId ,int lessonCurrentId);
    void updateNewScore(int score, int lessonId);
}
