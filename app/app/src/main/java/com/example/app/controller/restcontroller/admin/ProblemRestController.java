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

import com.example.app.dto.requestDTO.ProblemDTORequest;
import com.example.app.dto.responseDTO.ProblemDTOResponse;
import com.example.app.service.serviceInterface.ProblemService;




@RestController
@RequestMapping("/admin/api")
public class ProblemRestController {
    
    @Autowired
    private ProblemService problemService;

    @GetMapping("/problems/list")
    public List<ProblemDTOResponse> getAllProblems() {
        return problemService.getAllProblems();
    }

    @PostMapping("/problem/add")
    public void insertNewProblem(@RequestBody ProblemDTORequest request ) {
        problemService.createProblem(request);
    }

    @PutMapping("/problem/update/{id}")
    public void updateProblem(@PathVariable int id, @RequestBody ProblemDTORequest request) {
        problemService.updateProblem(id, request);
    }


    @DeleteMapping("/problem/delete/{id}")
    public void deleteProblem(@PathVariable int id) {
        problemService.deleteProblem(id);
    }
    

    

}
