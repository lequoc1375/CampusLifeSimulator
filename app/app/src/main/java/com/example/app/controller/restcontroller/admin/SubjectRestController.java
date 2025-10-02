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

import com.example.app.dto.requestDTO.SubjectDTORequest;
import com.example.app.dto.responseDTO.SubjectDTOResponse;
import com.example.app.service.serviceInterface.SubjectService;

@RestController
@RequestMapping("/admin/api")
public class SubjectRestController {

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
