package com.example.app.service.serviceInterface;

import java.util.List;
import java.util.Map;

import com.example.app.entity.SubjectSelectedMidterm;

public interface SubjectSelectedMidtermService {
    void updateScore(int midtermId, int subjectId,int userCurriculumId, double grade);
    void updateExamStatus(int midtermId, int subjectId,int userCurriculumId);
    void updateAvaiStatus(int midtermId, int subjectId,int userCurriculumId);
    Map<String, String> getAvaiStatus(int midtermId, int subjectId, int userCurriculumId);
    List<SubjectSelectedMidterm> getAllSubjectSelectedMidterm();
    Map<String, String> getFinishedStatus(int midtermId, int subjectId, int userCurriculumId);
    void insert(int subjectRegisterId);
    SubjectSelectedMidterm getBySubjectRegisterId(int subjectRegisterId);
    
}
