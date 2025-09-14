package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.SubjectDTORequest;
import com.example.app.dto.responseDTO.SubjectDTOResponse;
import com.example.app.entity.Subject;

public interface SubjectService {
    List<SubjectDTOResponse> getAllSubjects();

    SubjectDTOResponse getSubjectById(int id);

    void createSubject(SubjectDTORequest request);

    void updateSubject(int id, SubjectDTORequest request);

    void deleteSubject(int id);

    List<Subject> getUnregisteredSubjectsByUserId(int userId);

    List<Subject> getInProgressSubjectsByUserId(int userId);

    List<Subject> getCompletedSubjectsByUserId(int userId);
    
    void registerSubjectForUser(int userId, int subjectId);
    
}
