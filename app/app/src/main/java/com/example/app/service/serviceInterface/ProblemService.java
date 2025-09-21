package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.ProblemDTORequest;
import com.example.app.dto.responseDTO.ProblemDTOResponse;

public interface ProblemService {

    List<ProblemDTOResponse> getAllProblems();
    ProblemDTOResponse getProblem(int id);
    void updateProblem(int id, ProblemDTORequest request);
    void createProblem(ProblemDTORequest request);
    void deleteProblem(int id);
    List<ProblemDTOResponse> getAllProblemByLesson(int lessonId);

}
