package com.example.app.controller.restcontroller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.requestDTO.ProblemDTORequest;
import com.example.app.dto.responseDTO.ProblemDTOResponse;
import com.example.app.service.serviceImpl.CloudinaryService;
import com.example.app.service.serviceInterface.ProblemService;

@RestController
@RequestMapping("/admin/api")
public class ProblemRestController {

    @Autowired
    private ProblemService problemService;

    @Autowired
    private CloudinaryService cloudinaryService;

    @GetMapping("/problems/list")
    public List<ProblemDTOResponse> getAllProblems() {
        return problemService.getAllProblems();
    }

    @PostMapping("/problem/add")
    public ResponseEntity<?> addProblem(
            @RequestParam("lessonId") Integer lessonId,
            @RequestParam("problem_order") Integer problemOrder,
            @RequestParam("question_image") MultipartFile questionImage,
            @RequestParam("answer_image") MultipartFile answerImage,
            @RequestParam("answer") String answer) {
        try {

            String questionImageUrl = cloudinaryService.uploadFile(questionImage);
            String answerImageUrl = cloudinaryService.uploadFile(answerImage);

            problemService.createProblem(lessonId,problemOrder,questionImageUrl,answerImageUrl,answer);

            return ResponseEntity.ok("Problem created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/problem/update/{id}")
    public ResponseEntity<?> updateProblemForm(
            @PathVariable Integer id,
            @RequestParam("lessonId") Integer lessonId,
            @RequestParam("problem_order") Integer problemOrder,
            @RequestParam(value = "question_image", required = false) MultipartFile questionImage,
            @RequestParam(value = "answer_image", required = false) MultipartFile answerImage,
            @RequestParam("answer") String answer) {
        problemService.updateProblem(id, lessonId, problemOrder, questionImage, answerImage, answer);
        return ResponseEntity.ok("Updated successfully");
    }

    @DeleteMapping("/problem/delete/{id}")
    public void deleteProblem(@PathVariable int id) {
        problemService.deleteProblem(id);
    }

}
