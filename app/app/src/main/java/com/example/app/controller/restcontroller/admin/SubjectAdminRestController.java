package com.example.app.controller.restcontroller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.app.dto.responseDTO.SubjectDTOResponse;
import com.example.app.service.serviceInterface.SubjectService;

import com.example.app.dto.requestDTO.SubjectDTORequest;

@RestController
@RequestMapping("/admin/api")
public class SubjectAdminRestController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subjects/get")
    public List<SubjectDTOResponse> getSubjects() {
        return subjectService.getAllSubjects();
    }

    @PostMapping("/subject/add")
    public void addNewSubject(@RequestBody SubjectDTORequest request) {
        subjectService.createSubject(request);
    }

    @PutMapping("/subject/update/{subjectId}")
    public void updateSubject(@PathVariable int subjectId, @RequestBody SubjectDTORequest request) {
        subjectService.updateSubject(subjectId, request);
    }

    @DeleteMapping("/subject/delete/{subjectId}")
    public void deleteSubject(@PathVariable int subjectId) {
        subjectService.deleteSubject(subjectId);
    }

}
