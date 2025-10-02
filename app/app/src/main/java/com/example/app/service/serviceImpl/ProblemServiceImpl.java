package com.example.app.service.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.mapper.ProblemMapper;
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
    @Autowired
    private CloudinaryService cloudinaryService;

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
    public void createProblem(Integer lessonId,
            Integer problemOrder,
            String questionImageUrl,
            String answerImageUrl,
            String answer) {

        Lesson lesson = lessonRepo.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson  is not valid"));

        Problem problem = new Problem();

        problem.setProblem_order(problemOrder);
        problem.setQuestion_image(questionImageUrl);
        problem.setAnswer_image(answerImageUrl);
        problem.setAnswer(answer);
        problem.setLesson(lesson);
        problemRepo.save(problem);
    }

    @Override
    public void deleteProblem(int id) {
        Problem problem = problemRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Problem  is not valid"));
        problemRepo.delete(problem);
    }

    @Override
    public List<ProblemDTOResponse> getAllProblemByLesson(int lessonId) {
        return problemRepo.findByLesson_LessonId(lessonId).stream().map(problemMapper::convertToProblemDTOResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void updateProblem(Integer id, Integer lessonId, Integer problemOrder,
                              MultipartFile questionImage, MultipartFile answerImage,
                              String answer) {
        Problem problem = problemRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Problem not found"));
    
        Lesson lesson = lessonRepo.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson is not valid"));
    
        problem.setLesson(lesson);
        problem.setProblem_order(problemOrder);
        problem.setAnswer(answer);
    
        if (questionImage != null && !questionImage.isEmpty()) {
            try {
                String url = cloudinaryService.uploadFile(questionImage);
                problem.setQuestion_image(url);
            } catch (IOException ex) {
                throw new RuntimeException("Upload question image failed", ex);
            }
        }
    
        if (answerImage != null && !answerImage.isEmpty()) {
            try {
                String url = cloudinaryService.uploadFile(answerImage);
                problem.setAnswer_image(url);
            } catch (IOException ex) {
                throw new RuntimeException("Upload answer image failed", ex);
            }
        }
    
    
        problemRepo.save(problem);
    }
    

}
