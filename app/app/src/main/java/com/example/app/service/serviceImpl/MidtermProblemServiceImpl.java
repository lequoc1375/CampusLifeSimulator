package com.example.app.service.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.mapper.MidtermProblemMapper;
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

    @Autowired
    private CloudinaryService cloudinaryService;

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
    public void deleteMidtermProblem(int id) {
        MidtermProblem entity = midtermProblemRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Midterm Problem 4.3 not found"));
        midtermProblemRepo.delete(entity);
    }

    @Override
    public List<MidtermProblem> getAllMidtermProblemsByMidtermId(int midtermId) {
        MidtermDTOResponse midterm = midtermService.getMidterm(midtermId);
        return midterm.getProblems();
    }

    @Override
    public void createMidtermProblem(int midtermId, int problemOrder, String answer, MultipartFile questionImage,
            MultipartFile answerImage) {
        Midterm midterm = midtermRepo.findById(midtermId)
                .orElseThrow(() -> new RuntimeException("Midterm not found"));

        MidtermProblem entity = new MidtermProblem();
        entity.setMidterm(midterm);
        entity.setProblemOrder(problemOrder);
        entity.setAnswer(answer);

        if (questionImage != null && !questionImage.isEmpty()) {
            try {
                String url = cloudinaryService.uploadFile(questionImage);
                entity.setQuestionImage(url);
            } catch (IOException ex) {
                throw new RuntimeException("Upload question image failed", ex);
            }
        }

        if (answerImage != null && !answerImage.isEmpty()) {
            try {
                String url = cloudinaryService.uploadFile(answerImage);
                entity.setAnswerImage(url);
            } catch (IOException ex) {
                throw new RuntimeException("Upload answer image failed", ex);
            }
        }

        midtermProblemRepo.save(entity);
    }

    @Override
    public void updateMidtermProblem(int id, int midtermId, int problemOrder, String answer,
            MultipartFile questionImage, MultipartFile answerImage) {
        MidtermProblem entity = midtermProblemRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Midterm problem not found"));

        Midterm midterm = midtermRepo.findById(midtermId)
                .orElseThrow(() -> new RuntimeException("Midterm not found"));

        entity.setMidterm(midterm);
        entity.setProblemOrder(problemOrder);
        entity.setAnswer(answer);

        if (questionImage != null && !questionImage.isEmpty()) {
            try {
                String url = cloudinaryService.uploadFile(questionImage);
                entity.setQuestionImage(url);
            } catch (IOException ex) {
                throw new RuntimeException("Upload question image failed", ex);
            }
        }

        if (answerImage != null && !answerImage.isEmpty()) {
            try {
                String url = cloudinaryService.uploadFile(answerImage);
                entity.setAnswerImage(url);
            } catch (IOException ex) {
                throw new RuntimeException("Upload answer image failed", ex);
            }
        }

        midtermProblemRepo.save(entity);
    }
}
