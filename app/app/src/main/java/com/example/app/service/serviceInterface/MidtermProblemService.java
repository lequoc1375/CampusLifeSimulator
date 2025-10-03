package com.example.app.service.serviceInterface;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.responseDTO.MidtermProblemDTOResponse;
import com.example.app.entity.MidtermProblem;

public interface MidtermProblemService {

    List<MidtermProblemDTOResponse> getAllMidtermProblems();

    MidtermProblemDTOResponse getMidtermProblemById(int id);

    void createMidtermProblem(int midtermId, int problemOrder, String answer, MultipartFile questionImage, MultipartFile answerImage);

    void updateMidtermProblem(int id, int midtermId, int problemOrder, String answer, MultipartFile questionImage, MultipartFile answerImage);

    void deleteMidtermProblem(int id);

    List<MidtermProblem> getAllMidtermProblemsByMidtermId(int midtermId);
}
