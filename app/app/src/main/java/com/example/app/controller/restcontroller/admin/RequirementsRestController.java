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

import com.example.app.dto.requestDTO.RequirementsDTORequest;
import com.example.app.dto.responseDTO.RequirementsDTOResponse;
import com.example.app.service.serviceInterface.RequirementsService;

@RestController
@RequestMapping("/admin/api/requirement")
public class RequirementsRestController {
    @Autowired
    private RequirementsService requirementService;

    @GetMapping("/list")
    public List<RequirementsDTOResponse> getAll() {
        return requirementService.getAll();
    }

    @GetMapping("/{id}")
    public RequirementsDTOResponse getById(@PathVariable int id) {
        return requirementService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody RequirementsDTORequest request) {
        requirementService.create(request);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable int id, @RequestBody RequirementsDTORequest request) {
        requirementService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        requirementService.delete(id);
    }
}
