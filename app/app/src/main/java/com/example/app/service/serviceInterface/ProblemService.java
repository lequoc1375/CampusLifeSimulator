package com.example.app.service.serviceInterface;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.responseDTO.ProblemDTOResponse;

public interface ProblemService {

    List<ProblemDTOResponse> getAllProblems();

    ProblemDTOResponse getProblem(int id);

    void updateProblem(Integer id,
            Integer lessonId,
            Integer problemOrder,
            MultipartFile questionImage,
            MultipartFile answerImage,
            String answer);

    void createProblem(Integer lessonId,
            Integer problemOrder,
            String questionImageUrl,
            String answerImageUrl,
            String answer);

    void deleteProblem(int id);

    List<ProblemDTOResponse> getAllProblemByLesson(int lessonId);

}
