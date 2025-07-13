package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.FinalProblemDTORequest;
import com.example.app.dto.responseDTO.FinalProblemDTOResponse;

public interface FinalProblemService {
    List<FinalProblemDTOResponse> getAllFinalProblems();

    FinalProblemDTOResponse getFinalProblemById(int id);

    void createFinalProblem(FinalProblemDTORequest request);

    void updateFinalProblem(int id, FinalProblemDTORequest request);

    void deleteFinalProblem(int id);
}
