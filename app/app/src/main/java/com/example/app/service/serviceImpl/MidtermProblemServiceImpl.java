package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.MidtermProblemMapper;
import com.example.app.dto.requestDTO.MidtermProblemDTORequest;
import com.example.app.dto.responseDTO.MidtermDTOResponse;
import com.example.app.dto.responseDTO.MidtermProblemDTOResponse;
import com.example.app.entity.Midterm;
import com.example.app.entity.MidtermProblem;
import com.example.app.repository.MidtermProblemRepo;
import com.example.app.repository.MidtermRepo;
import com.example.app.service.serviceInterface.MidtermProblemService;
import com.example.app.service.serviceInterface.MidtermService;

@Service
public class MidtermProblemServiceImpl implements MidtermProblemService {

    @Autowired
    private MidtermProblemRepo midtermProblemRepo;

    @Autowired
    private MidtermRepo midtermRepo;

    @Autowired
    private MidtermService midtermService;

    @Autowired
    private MidtermProblemMapper midtermProblemMapper;

    @Override
    public List<MidtermProblemDTOResponse> getAllMidtermProblems() {
        return midtermProblemRepo.findAll()
                .stream()
                .map(midtermProblemMapper::convertToMidtermProblemDTOResponse)
                .collect(Collectors.toList());
    }

    @Override
    public MidtermProblemDTOResponse getMidtermProblemById(int id) {
        MidtermProblem entity = midtermProblemRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Midterm Problem 4.1 not found"));
        return midtermProblemMapper.convertToMidtermProblemDTOResponse(entity);
    }

    @Override
    public void createMidtermProblem(MidtermProblemDTORequest request) {
        MidtermProblem entity = midtermProblemMapper.convertToMidtermProblem(request);
        Midterm midterm = midtermRepo.findById(request.getMidtermId())
                .orElseThrow(() -> new RuntimeException("Midterm 4.1 not found"));

        entity.setMidterm(midterm);
        midtermProblemRepo.save(entity);
    }

    @Override
    public void updateMidtermProblem(int id, MidtermProblemDTORequest request) {
        MidtermProblem entity = midtermProblemRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Midterm Problem 4.2 not exist"));

        entity.setProblemOrder(request.getProblemOrder());
        entity.setQuestionImage(request.getQuestionImage());
        entity.setAnswerImage(request.getAnswerImage());
        entity.setAnswer(request.getAnswer());

        Midterm midterm = midtermRepo.findById(request.getMidtermId())
                .orElseThrow(() -> new RuntimeException("Midterm 4.2 not found"));
        entity.setMidterm(midterm);

        midtermProblemRepo.save(entity);
    }

    @Override
    public void deleteMidtermProblem(int id) {
        MidtermProblem entity = midtermProblemRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Midterm Problem 4.3 not found"));
        midtermProblemRepo.delete(entity);
    }

    @Override
    public List<MidtermProblem> getAllMidtermProblemsByMidtermId(int midtermId) {
        MidtermDTOResponse midterm  = midtermService.getMidterm(midtermId);
        return  midterm.getProblems();
    }
}
