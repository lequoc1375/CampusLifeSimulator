package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.Lesson;
import com.example.app.entity.LessonStudying;
import com.example.app.entity.SubjectRegister;
import com.example.app.repository.LessonRepo;
import com.example.app.repository.LessonStudyingRepo;
import com.example.app.repository.SubjectRegisterRepo;
import com.example.app.service.serviceInterface.LessonStudyingService;

@Service
public class LessonStudyingServiceImpl implements LessonStudyingService {

    @Autowired
    private LessonStudyingRepo lessonStudyingRepo;

    @Autowired
    private LessonRepo lessonRepo;

    @Autowired
    private SubjectRegisterRepo subjectRegisterRepo;

    @Override
    public void insert(int userId, List<Integer> lessonIds, int subjectRegisterId) {
        SubjectRegister subjectRegister = subjectRegisterRepo.findById(subjectRegisterId)
                .orElseThrow(() -> new RuntimeException("SubjectRegister not found"));

        List<LessonStudying> lessonStudyingList = lessonIds.stream().map(lessonId -> {
            Lesson lesson = lessonRepo.findById(lessonId)
                    .orElseThrow(() -> new RuntimeException("Lesson not found: " + lessonId));

            LessonStudying ls = new LessonStudying();
            ls.setAvaiStatus(LessonStudying.AvailabilityStatus.unable);
            ls.setStudyStatus(LessonStudying.StudyStatus.unfinished);
            ls.setLesson(lesson);
            ls.setSubjectRegister(subjectRegister);
            ls.setVideoStatus(LessonStudying.VideoStatus.unfinished);
            System.out.println("AvaiStatus: " + ls.getAvaiStatus()); 
            return ls;
        }).collect(Collectors.toList());

        lessonStudyingRepo.saveAll(lessonStudyingList);
    }

    @Override
    public void updateFinishedVideo(int lessonId) {
        LessonStudying ls = lessonStudyingRepo.findByLessonId(lessonId)
                .orElseThrow(() -> new RuntimeException("LessonStudying not found"));
        ls.setVideoStatus(LessonStudying.VideoStatus.finished);
        lessonStudyingRepo.save(ls); 
    }

    @Override
    public void updateFinishedQuiz(int lessonId) {
        LessonStudying ls = lessonStudyingRepo.findByLessonId(lessonId)
                .orElseThrow(() -> new RuntimeException("LessonStudying not found"));
        ls.setStudyStatus(LessonStudying.StudyStatus.finished);
        lessonStudyingRepo.save(ls); 
    }

    @Override
    public void updateAbleNextLesson(int subjectId, int lessonCurrentOrder) {
        int lessonId = lessonStudyingRepo.findNextLessonStudyingBySubjectIdAndCurrentOrder(subjectId, lessonCurrentOrder).get();
        LessonStudying ls = lessonStudyingRepo.findByLessonId(lessonId)
            .orElseThrow(() -> new RuntimeException("LessonStudying not found"));
        ls.setAvaiStatus(LessonStudying.AvailabilityStatus.able);
        lessonStudyingRepo.save(ls); 
    }

    @Override
    public void updateNewScore(int score, int lessonId) {
        LessonStudying ls = lessonStudyingRepo.findByLessonId(lessonId)
            .orElseThrow(() -> new RuntimeException("LessonStudying not found"));
        int newScore = ls.getScore() + score;
        if (newScore < 0) {
            newScore = 0; 
        } else if (newScore > 6) {
            newScore = 6; 
        }
        ls.setScore(newScore);
        lessonStudyingRepo.save(ls); 
    }

    @Override
    public boolean visitedOrNot(int lesssonId) {
        LessonStudying ls = lessonStudyingRepo.findByLessonId(lesssonId).orElseThrow(() -> new RuntimeException("LessonStudying not found"));
        
        if(ls.isVisited()) return true;
        return false;
    }

    @Override
    public void setVisited(int lessonId, boolean visited) {
        LessonStudying ls = lessonStudyingRepo.findByLessonId(lessonId).orElseThrow(() -> new RuntimeException("LessonStudying not found"));
        ls.setVisited(visited);
        lessonStudyingRepo.save(ls);
    }

    @Override
    public List<LessonStudying> getAll() {
        return lessonStudyingRepo.findAll();
    }

    @Override
    public void save(LessonStudying ls) {
        lessonStudyingRepo.save(ls);
    }
}
