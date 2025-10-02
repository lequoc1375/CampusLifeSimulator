package com.example.app.controller.restcontroller.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.dto.responseDTO.ProblemDTOResponse;
import com.example.app.service.serviceInterface.ProblemService;

@RestController
@RequestMapping("/player/api/lesson")
public class ProblemPlayerRestController {

    @Autowired
    private ProblemService problemService;

    @GetMapping("/getProblems/{lessonId}")
    public ResponseEntity<List<ProblemDTOResponse>> getProblems(@PathVariable int lessonId) {
        List<ProblemDTOResponse> problems = problemService.getAllProblemByLesson(lessonId);

        if (problems.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(problems);
    }

}
