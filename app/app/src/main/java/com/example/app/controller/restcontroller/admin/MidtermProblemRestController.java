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

import com.example.app.dto.requestDTO.MidtermProblemDTORequest;
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
    public void addMidtermProblem(@RequestBody MidtermProblemDTORequest request) {
        midtermProblemService.createMidtermProblem(request);
    }

    @PutMapping("/update/{id}")
    public void updateMidtermProblem(@PathVariable int id, @RequestBody MidtermProblemDTORequest request) {
        midtermProblemService.updateMidtermProblem(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMidtermProblem(@PathVariable int id) {
        midtermProblemService.deleteMidtermProblem(id);
    }
}
