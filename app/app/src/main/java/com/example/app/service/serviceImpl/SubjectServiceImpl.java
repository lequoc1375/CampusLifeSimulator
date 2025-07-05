package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.SubjectMapper;
import com.example.app.dto.requestDTO.SubjectDTORequest;
import com.example.app.dto.responseDTO.SubjectDTOResponse;
import com.example.app.entity.Subject;
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
        Subject subject = subjectMapper.convertToSubject(request);
        subjectRepo.save(subject);

    }

    @Override
    public void updateSubject(int id, SubjectDTORequest request) {
        Subject subject = subjectRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found for update"));
        subject.setName(request.getName());
        subject.setCredit(request.getCredit());
        subjectRepo.save(subject);

    }

    @Override
    public void deleteSubject(int id) {
        Subject subject = subjectRepo.findById(id).orElseThrow(()-> new RuntimeException("Not find subject for delete"));
        subjectRepo.delete(subject);
    }

}
