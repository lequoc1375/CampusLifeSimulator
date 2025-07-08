package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.ProblemMapper;
import com.example.app.dto.requestDTO.ProblemDTORequest;
import com.example.app.dto.responseDTO.ProblemDTOResponse;
import com.example.app.entity.Lesson;
import com.example.app.entity.Problem;
import com.example.app.repository.LessonRepo;
import com.example.app.repository.ProblemRepo;
import com.example.app.service.serviceInterface.ProblemService;
@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private ProblemRepo problemRepo;

    @Autowired
    private ProblemMapper problemMapper;
    @Autowired
    private LessonRepo lessonRepo;

    @Override
    public List<ProblemDTOResponse> getAllProblems() {
        return problemRepo.findAll().stream().map(problemMapper::convertToProblemDTOResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProblemDTOResponse getProblem(int id) {
        Problem problem = problemRepo.findById(id).orElseThrow(() -> new RuntimeException("Problem is not found"));
        return problemMapper.convertToProblemDTOResponse(problem);
    }

    @Override
    public void updateProblem(int id, ProblemDTORequest request) {
        Problem problem = problemRepo.findById(id).orElseThrow(() -> new RuntimeException("Problem is not found"));
        problem.setAnswer(request.getAnswer());
        problem.setAnswer_image(request.getAnswer_image());
        problem.setQuestion_image(request.getQuestion_image());
        Lesson lesson = lessonRepo.findById(request.getLesson_id())
                .orElseThrow(() -> new RuntimeException("Lesson is not found in Problem"));
        problem.setLesson(lesson);
        problemRepo.save(problem);
    }

    @Override
    public void createProblem(ProblemDTORequest request) {
        Problem problem = problemMapper.convertToProblem(request);

        Lesson lesson = lessonRepo.findById(request.getLesson_id())
                .orElseThrow(() -> new RuntimeException("Lesson  is not valid"));

        problem.setLesson(lesson);
        problemRepo.save(problem);
    }

    @Override
    public void deleteProblem(int id) {
        Problem problem = problemRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Problem  is not valid"));
        problemRepo.delete(problem);
    }

}
