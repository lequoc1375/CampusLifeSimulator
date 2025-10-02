package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.FinalMapper;
import com.example.app.dto.requestDTO.FinalDTORequest;
import com.example.app.dto.responseDTO.FinalDTOResponse;
import com.example.app.entity.FinalExam;
import com.example.app.entity.Subject;
import com.example.app.repository.FinalRepo;
import com.example.app.repository.SubjectRepo;
import com.example.app.service.serviceInterface.FinalService;

@Service
public class FinalServiceImpl implements FinalService {

    @Autowired
    private FinalRepo finalExamRepo;

    @Autowired
    private SubjectRepo subjectRepo;

    @Autowired
    private FinalMapper finalExamMapper;

    @Override
    public List<FinalDTOResponse> getAllFinal() {
        return finalExamRepo.findAll()
                .stream()
                .map(finalExamMapper::convertToFinalDTOResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FinalDTOResponse getFinal(int id) {
        FinalExam exam = finalExamRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Final 4.1 is not valid"));
        return finalExamMapper.convertToFinalDTOResponse(exam);
    }

    @Override
    public void updateFinal(Integer id, FinalDTORequest request) {
        FinalExam exam = finalExamRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Final 4.2 is not exist"));

        exam.setTime(request.getTime());

        Subject subject = subjectRepo.findById(request.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject 4.2 is not exist"));

        exam.setSubject(subject);

        finalExamRepo.save(exam);
    }

    @Override
    public void deleteFinal(Integer id) {
        FinalExam exam = finalExamRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Final 4.3 is not valid"));
        finalExamRepo.delete(exam);
    }

    @Override
    public void addFinal(FinalDTORequest dto) {
        FinalExam exam = finalExamMapper.convertToFinal(dto);

        Subject subject = subjectRepo.findById(dto.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject 4.1 is not valid"));

        exam.setSubject(subject);
        finalExamRepo.save(exam);
    }
}
