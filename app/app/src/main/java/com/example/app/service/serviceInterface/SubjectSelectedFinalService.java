package com.example.app.service.serviceInterface;

import java.util.List;
import java.util.Map;

import com.example.app.entity.SubjectSelectedFinal;

public interface SubjectSelectedFinalService {
    void updateScore(int finalId, int subjectId,int userCurriculumId, double grade);
    void updateExamFinishedStatus(int finalId, int subjectId, int userCurriculumId);
    void updateAvaiStatus(int finalId, int subjectId,int userCurriculumId);
    Map<String, String> getAvaiStatus(int finalId, int subjectId, int userCurriculumId);
    List<SubjectSelectedFinal> getAllSubjectSelectedFinal();
    Map<String, String> getFinishedStatus(int finalId, int subjectId, int userCurriculumId);
    void insert(int subjectRegisterId);
    SubjectSelectedFinal getBySubjectRegisterId(int subjectRegisterId);
}
