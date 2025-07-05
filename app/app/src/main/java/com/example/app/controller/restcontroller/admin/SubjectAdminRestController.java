package com.example.app.controller.restcontroller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.dto.responseDTO.SubjectDTOResponse;
import com.example.app.service.serviceInterface.SubjectService;


@RestController
@RequestMapping("/admin/api")
public class SubjectAdminRestController {

    @Autowired
    private SubjectService subjectService;

    
    @GetMapping("/subjects/get")
    public List<SubjectDTOResponse> getSubjects() {
        return subjectService.getAllSubjects();
    }
    
    
}
