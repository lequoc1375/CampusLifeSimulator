package com.example.app.service.serviceImpl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.SubjectRegister;
import com.example.app.entity.SubjectSelectedMidterm;
import com.example.app.repository.SubjectRegisterRepo;
import com.example.app.repository.SubjectSelectedMidtermRepo;
import com.example.app.service.serviceInterface.SubjectSelectedMidtermService;
@Service
public class SubjectSelectedMidtermServiceImpl implements SubjectSelectedMidtermService {

    @Autowired
    private SubjectSelectedMidtermRepo subjectSelectedMidtermRepo;

    @Autowired
    private SubjectRegisterRepo subjectRegisterRepo;


    @Override
    public void updateScore(int midtermId, int subjectId, int userCurriculumId, double grade) {
        Integer subjectRegisterId = subjectRegisterRepo.findIdBySubjectIdAndUserCurriculumId(subjectId, userCurriculumId);
        System.out.println("/n");
        System.out.println("///////////////////////////////////////////");
        System.out.println(midtermId);
        System.out.println(subjectId);
        System.out.println(userCurriculumId);
        System.out.println(subjectRegisterId);
        System.out.println("/n");
        System.out.println("/n");
        SubjectSelectedMidterm sb = subjectSelectedMidtermRepo.findBySubjectRegisterIdAndMidtermId(subjectRegisterId, midtermId);
        sb.setGrade(BigDecimal.valueOf(grade));
        subjectSelectedMidtermRepo.save(sb);
    }


    @Override
    public void updateExamStatus(int midtermId, int subjectId, int userCurriculumId) {
        Integer subjectRegisterId = subjectRegisterRepo.findIdBySubjectIdAndUserCurriculumId(subjectId, userCurriculumId);
        SubjectSelectedMidterm sb = subjectSelectedMidtermRepo.findBySubjectRegisterIdAndMidtermId(subjectRegisterId, midtermId);
        sb.setExamStatus(SubjectSelectedMidterm.ExamStatus.finished);
        subjectSelectedMidtermRepo.save(sb);     
    }


    @Override
    public Map<String, String> getAvaiStatus(int midtermId, int subjectId, int userCurriculumId) {
        Map<String, String> result = new HashMap<>();
        Integer subjectRegisterId = subjectRegisterRepo.findIdBySubjectIdAndUserCurriculumId(subjectId, userCurriculumId);
        SubjectSelectedMidterm sb = subjectSelectedMidtermRepo.findBySubjectRegisterIdAndMidtermId(subjectRegisterId, midtermId);
        result.put("status",sb.getAvailabilityStatus().toString());
        return result;
    }


    @Override
    public List<SubjectSelectedMidterm> getAllSubjectSelectedMidterm() {
       return subjectSelectedMidtermRepo.findAll();
    }


    @Override
    public Map<String, String> getFinishedStatus(int midtermId, int subjectId, int userCurriculumId) {
        Map<String, String> result = new HashMap<>();
        Integer subjectRegisterId = subjectRegisterRepo.findIdBySubjectIdAndUserCurriculumId(subjectId, userCurriculumId);
        SubjectSelectedMidterm sb = subjectSelectedMidtermRepo.findBySubjectRegisterIdAndMidtermId(subjectRegisterId, midtermId);
        result.put("status",sb.getExamStatus().toString());
        return result;
    }


    @Override
    public void updateAvaiStatus(int midtermId, int subjectId, int userCurriculumId) {
        Integer subjectRegisterId = subjectRegisterRepo.findIdBySubjectIdAndUserCurriculumId(subjectId, userCurriculumId);
        SubjectSelectedMidterm sb = subjectSelectedMidtermRepo.findBySubjectRegisterIdAndMidtermId(subjectRegisterId, midtermId);
        sb.setAvailabilityStatus(SubjectSelectedMidterm.AvailabilityStatus.unable);
        subjectSelectedMidtermRepo.save(sb);  
    }


    @Override
    public void insert(int subjectRegisterId) {
        SubjectRegister subjectRegister = subjectRegisterRepo.findById(subjectRegisterId).orElseThrow(() -> new RuntimeException("subjectRegister can not be found"));
        SubjectSelectedMidterm sb = new SubjectSelectedMidterm();
        sb.setAvailabilityStatus(SubjectSelectedMidterm.AvailabilityStatus.unable);
        sb.setExamStatus(SubjectSelectedMidterm.ExamStatus.unfinished);
        sb.setGrade(BigDecimal.valueOf(0));
        sb.setSubjectRegister(subjectRegister);
        subjectSelectedMidtermRepo.save(sb);

    }


    @Override
    public SubjectSelectedMidterm getBySubjectRegisterId(int subjectRegisterId) {
        return subjectSelectedMidtermRepo.findBySubjectRegisterId(subjectRegisterId);
    }

}
