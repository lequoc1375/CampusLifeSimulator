package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.SubjectDTORequest;
import com.example.app.dto.responseDTO.SubjectDTOResponse;

public interface SubjectService {
    List<SubjectDTOResponse> getAllSubjects();

    SubjectDTOResponse getSubjectById(int id);

    void createSubject(SubjectDTORequest request);

    void updateSubject(int id, SubjectDTORequest request);

    void deleteSubject(int id);
}
