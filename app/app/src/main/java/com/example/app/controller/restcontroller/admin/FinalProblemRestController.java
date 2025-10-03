package com.example.app.controller.restcontroller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.responseDTO.FinalProblemDTOResponse;
import com.example.app.service.serviceInterface.FinalProblemService;

@RestController
@RequestMapping("/admin/api/final-problem")
public class FinalProblemRestController {

    @Autowired
    private FinalProblemService finalProblemService;

    @GetMapping("/list")
    public List<FinalProblemDTOResponse> getAllFinalProblems() {
        return finalProblemService.getAllFinalProblems();
    }

    @GetMapping("/{id}")
    public FinalProblemDTOResponse getFinalProblemById(@PathVariable int id) {
        return finalProblemService.getFinalProblemById(id);
    }

    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void addFinalProblem(
            @RequestParam("finalId") int finalId,
            @RequestParam("problemOrder") int problemOrder,
            @RequestParam("answer") String answer,
            @RequestPart("questionImage") MultipartFile questionImage,
            @RequestPart("answerImage") MultipartFile answerImage) {
        finalProblemService.createFinalProblem(finalId, problemOrder, answer, questionImage, answerImage);
    }

    @PutMapping(value = "/update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateFinalProblem(
            @PathVariable int id,
            @RequestParam("finalId") int finalId,
            @RequestParam("problemOrder") int problemOrder,
            @RequestParam("answer") String answer,
            @RequestPart(value = "questionImage", required = false) MultipartFile questionImage,
            @RequestPart(value = "answerImage", required = false) MultipartFile answerImage) {
        finalProblemService.updateFinalProblem(id, finalId, problemOrder, answer, questionImage, answerImage);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFinalProblem(@PathVariable int id) {
        finalProblemService.deleteFinalProblem(id);
    }
}
