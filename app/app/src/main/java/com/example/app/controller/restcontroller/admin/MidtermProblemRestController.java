package com.example.app.controller.restcontroller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.responseDTO.MidtermProblemDTOResponse;
import com.example.app.service.serviceInterface.MidtermProblemService;

@RestController
@RequestMapping("/admin/api/midterm-problem")
public class MidtermProblemRestController {

    @Autowired
    private MidtermProblemService midtermProblemService;

    @GetMapping("/list")
    public List<MidtermProblemDTOResponse> getAllMidtermProblems() {
        return midtermProblemService.getAllMidtermProblems();
    }

    @GetMapping("/{id}")
    public MidtermProblemDTOResponse getMidtermProblemById(@PathVariable int id) {
        return midtermProblemService.getMidtermProblemById(id);
    }

    @PostMapping("/add")
    public void addMidtermProblem(
            @RequestParam("midterm_id") int midtermId,
            @RequestParam("problem_order") int problemOrder,
            @RequestParam("answer") String answer,
            @RequestParam("question_image") MultipartFile questionImage,
            @RequestParam("answer_image") MultipartFile answerImage) {
        midtermProblemService.createMidtermProblem(midtermId, problemOrder, answer, questionImage, answerImage);
    }

    @PutMapping("/update/{id}")
    public void updateMidtermProblem(
            @PathVariable int id,
            @RequestParam("midterm_id") int midtermId,
            @RequestParam("problem_order") int problemOrder,
            @RequestParam("answer") String answer,
            @RequestParam(value = "question_image", required = false) MultipartFile questionImage,
            @RequestParam(value = "answer_image", required = false) MultipartFile answerImage) {
        midtermProblemService.updateMidtermProblem(id, midtermId, problemOrder, answer, questionImage, answerImage);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMidtermProblem(@PathVariable int id) {
        midtermProblemService.deleteMidtermProblem(id);
    }
}
