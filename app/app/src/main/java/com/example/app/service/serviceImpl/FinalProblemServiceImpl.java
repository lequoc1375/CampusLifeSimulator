package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.FinalProblemMapper;
import com.example.app.dto.requestDTO.FinalProblemDTORequest;
import com.example.app.dto.responseDTO.FinalProblemDTOResponse;
import com.example.app.entity.FinalExam;
import com.example.app.entity.FinalProblem;
import com.example.app.repository.FinalProblemRepo;
import com.example.app.repository.FinalRepo;
import com.example.app.service.serviceInterface.FinalProblemService;

@Service
public class FinalProblemServiceImpl implements FinalProblemService {

    @Autowired
    private FinalProblemRepo finalProblemRepo;

    @Autowired
    private FinalRepo finalRepo;

    @Autowired
    private FinalProblemMapper finalProblemMapper;

    @Override
    public List<FinalProblemDTOResponse> getAllFinalProblems() {
        return finalProblemRepo.findAll()
                .stream()
                .map(finalProblemMapper::convertToFinalProblemDTOResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FinalProblemDTOResponse getFinalProblemById(int id) {
        FinalProblem entity = finalProblemRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Final Problem 4.1 not found"));
        return finalProblemMapper.convertToFinalProblemDTOResponse(entity);
    }

    @Override
    public void createFinalProblem(FinalProblemDTORequest request) {
        FinalProblem entity = finalProblemMapper.convertToFinalProblem(request);
        FinalExam finalEntity = finalRepo.findById(request.getFinalId())
                .orElseThrow(() -> new RuntimeException("Final 4.1 not found"));

        entity.setFinalExam(finalEntity);
        finalProblemRepo.save(entity);
    }

    @Override
    public void updateFinalProblem(int id, FinalProblemDTORequest request) {
        FinalProblem entity = finalProblemRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Final Problem 4.2 not exist"));

        entity.setProblemOrder(request.getProblemOrder());
        entity.setQuestionImage(request.getQuestionImage());
        entity.setAnswerImage(request.getAnswerImage());
        entity.setAnswer(request.getAnswer());

        FinalExam finalEntity = finalRepo.findById(request.getFinalId())
                .orElseThrow(() -> new RuntimeException("Final 4.2 not found"));
        entity.setFinalExam(finalEntity);

        finalProblemRepo.save(entity);
    }

    @Override
    public void deleteFinalProblem(int id) {
        FinalProblem entity = finalProblemRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Final Problem 4.3 not found"));
        finalProblemRepo.delete(entity);
    }
}
