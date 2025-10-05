package com.example.app.service.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.mapper.FinalProblemMapper;
import com.example.app.dto.responseDTO.FinalDTOResponse;
import com.example.app.dto.responseDTO.FinalProblemDTOResponse;
import com.example.app.entity.FinalExam;
import com.example.app.entity.FinalProblem;
import com.example.app.repository.FinalProblemRepo;
import com.example.app.repository.FinalRepo;
import com.example.app.service.serviceInterface.FinalProblemService;
import com.example.app.service.serviceInterface.FinalService;

@Service
public class FinalProblemServiceImpl implements FinalProblemService {

    @Autowired
    private FinalProblemRepo finalProblemRepo;

    @Autowired
    private FinalRepo finalRepo;

    @Autowired
    private FinalProblemMapper finalProblemMapper;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    private FinalService finalService;

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
                .orElseThrow(() -> new RuntimeException("Final problem not found"));
        return finalProblemMapper.convertToFinalProblemDTOResponse(entity);
    }

    @Override
    public void deleteFinalProblem(int id) {
        FinalProblem entity = finalProblemRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Final problem not found"));
        finalProblemRepo.delete(entity);
    }

    @Override
    public void createFinalProblem(int finalId, int problemOrder, String answer, MultipartFile questionImage,
            MultipartFile answerImage) {
        FinalExam finalEntity = finalRepo.findById(finalId).orElseThrow();

        FinalProblem entity = new FinalProblem();
        entity.setFinalExam(finalEntity);
        entity.setProblemOrder(problemOrder);
        entity.setAnswer(answer);

        if (questionImage != null && !questionImage.isEmpty()) {
            try {
                String url = cloudinaryService.uploadFile(questionImage);
                entity.setQuestionImage(url);
            } catch (IOException ex) {
                throw new RuntimeException("Upload question image failed", ex);
            }
        } else {
            entity.setQuestionImage(null);
        }

        if (answerImage != null && !answerImage.isEmpty()) {
            try {
                String url = cloudinaryService.uploadFile(answerImage);
                entity.setAnswerImage(url);
            } catch (IOException ex) {
                throw new RuntimeException("Upload answer image failed", ex);
            }
        } else {
            entity.setAnswerImage(null);
        }

        finalProblemRepo.save(entity);
    }

    @Override
    public void updateFinalProblem(int id, int finalId, int problemOrder, String answer, MultipartFile questionImage,
            MultipartFile answerImage) {
        FinalProblem entity = finalProblemRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Final problem not found"));

        FinalExam finalEntity = finalRepo.findById(finalId)
                .orElseThrow(() -> new RuntimeException("Final not found"));

        entity.setFinalExam(finalEntity);
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

        finalProblemRepo.save(entity);
    }

    @Override
    public List<FinalProblem> getAllFinalProblemsByFinalId(int finalId) {
        FinalDTOResponse finalDTOResponse = finalService.getFinal(finalId);
        return finalDTOResponse.getProblems();
    }

}