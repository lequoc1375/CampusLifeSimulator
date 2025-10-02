package com.example.app.service.serviceImpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.app.repository.SubjectRegisterRepo;
import com.example.app.service.serviceInterface.SubjectRegisterService;

public class SubjectRegisterServiceImpl implements SubjectRegisterService {

    @Autowired
    private SubjectRegisterRepo subjectRegisterRepo;



}
