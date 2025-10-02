package com.example.app.controller.restcontroller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.dto.requestDTO.FinalProblemDTORequest;
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


    @PostMapping("/add")
    public void createFinalProblem(@RequestBody FinalProblemDTORequest request) {
        finalProblemService.createFinalProblem(request);
    }


    @PutMapping("/update/{id}")
    public void updateFinalProblem(@PathVariable int id, @RequestBody FinalProblemDTORequest request) {
        finalProblemService.updateFinalProblem(id, request);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteFinalProblem(@PathVariable int id) {
        finalProblemService.deleteFinalProblem(id);
    }
}
