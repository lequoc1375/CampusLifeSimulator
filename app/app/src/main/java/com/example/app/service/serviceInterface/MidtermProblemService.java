package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.MidtermProblemDTORequest;
import com.example.app.dto.responseDTO.MidtermProblemDTOResponse;
import com.example.app.entity.MidtermProblem;

public interface MidtermProblemService {

    List<MidtermProblemDTOResponse> getAllMidtermProblems();

    MidtermProblemDTOResponse getMidtermProblemById(int id);

    void createMidtermProblem(MidtermProblemDTORequest request);

    void updateMidtermProblem(int id, MidtermProblemDTORequest request);

    void deleteMidtermProblem(int id);

    List<MidtermProblem> getAllMidtermProblemsByMidtermId(int midtermId);
}
