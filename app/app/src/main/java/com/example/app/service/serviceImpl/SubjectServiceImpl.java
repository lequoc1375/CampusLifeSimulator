package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.SubjectMapper;
import com.example.app.dto.requestDTO.SubjectDTORequest;
import com.example.app.dto.responseDTO.SubjectDTOResponse;
import com.example.app.repository.SubjectRepo;
import com.example.app.service.serviceInterface.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepo subjectRepo;

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public List<SubjectDTOResponse> getAllSubjects() {
        return subjectRepo.findAll().stream().map(subjectMapper::convertToSubjectDTOResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SubjectDTOResponse getSubjectById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSubjectById'");
    }

    @Override
    public void createSubject(SubjectDTORequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createSubject'");
    }

    @Override
    public void updateSubject(int id, SubjectDTORequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSubject'");
    }

    @Override
    public void deleteSubject(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteSubject'");
    }

}
