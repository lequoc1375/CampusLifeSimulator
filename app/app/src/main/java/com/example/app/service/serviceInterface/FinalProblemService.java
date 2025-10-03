package com.example.app.service.serviceInterface;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.responseDTO.FinalProblemDTOResponse;
import com.example.app.entity.FinalProblem;

public interface FinalProblemService {
    List<FinalProblemDTOResponse> getAllFinalProblems();

    FinalProblemDTOResponse getFinalProblemById(int id);

    void createFinalProblem(int finalId, int problemOrder, String answer, MultipartFile questionImage, MultipartFile answerImage);

    void updateFinalProblem(int id, int finalId, int problemOrder, String answer, MultipartFile questionImage, MultipartFile answerImage);

    void deleteFinalProblem(int id);

     List<FinalProblem> getAllFinalProblemsByFinalId(int finalId);
}
