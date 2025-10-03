package com.example.app.service.serviceImpl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.SubjectRegister;
import com.example.app.entity.SubjectSelectedFinal;
import com.example.app.repository.SubjectRegisterRepo;
import com.example.app.repository.SubjectSelectedFinalRepo;
import com.example.app.service.serviceInterface.SubjectSelectedFinalService;

@Service
public class SubjectSelectedFinalServiceImpl implements SubjectSelectedFinalService {

     @Autowired
    private SubjectSelectedFinalRepo subjectSelectedFinalRepo;

    @Autowired
    private SubjectRegisterRepo subjectRegisterRepo;
    @Override
    public void updateScore(int finalId, int subjectId, int userCurriculumId, double grade) {
        Integer subjectRegisterId = subjectRegisterRepo.findIdBySubjectIdAndUserCurriculumId(subjectId, userCurriculumId);
        System.out.println("/n");
        System.out.println("///////////////////////////////////////////");
        System.out.println(finalId);
        System.out.println(subjectId);
        System.out.println(userCurriculumId);
        System.out.println(subjectRegisterId);
        System.out.println("/n");
        System.out.println("/n");
        SubjectSelectedFinal sb = subjectSelectedFinalRepo.findBySubjectRegisterIdAndFinalId(subjectRegisterId, finalId);
        sb.setGrade(BigDecimal.valueOf(grade));
        subjectSelectedFinalRepo.save(sb);
    }

    @Override
    public void updateExamFinishedStatus(int finalId, int subjectId, int userCurriculumId) {
        Integer subjectRegisterId = subjectRegisterRepo.findIdBySubjectIdAndUserCurriculumId(subjectId, userCurriculumId);
        SubjectSelectedFinal sb = subjectSelectedFinalRepo.findBySubjectRegisterIdAndFinalId(subjectRegisterId, finalId);
        sb.setExamStatus(SubjectSelectedFinal.ExamStatus.finished);
        subjectSelectedFinalRepo.save(sb); 
    }

    @Override
    public void updateAvaiStatus(int finalId, int subjectId, int userCurriculumId) {
         Integer subjectRegisterId = subjectRegisterRepo.findIdBySubjectIdAndUserCurriculumId(subjectId, userCurriculumId);
        SubjectSelectedFinal sb = subjectSelectedFinalRepo.findBySubjectRegisterIdAndFinalId(subjectRegisterId, finalId);
        sb.setAvailabilityStatus(SubjectSelectedFinal.AvailabilityStatus.unable);
        subjectSelectedFinalRepo.save(sb);   
    }

    @Override
    public Map<String, String> getAvaiStatus(int finalId, int subjectId, int userCurriculumId) {
        Map<String, String> result = new HashMap<>();
        Integer subjectRegisterId = subjectRegisterRepo.findIdBySubjectIdAndUserCurriculumId(subjectId, userCurriculumId);
        SubjectSelectedFinal sb = subjectSelectedFinalRepo.findBySubjectRegisterIdAndFinalId(subjectRegisterId, finalId);
        result.put("status",sb.getAvailabilityStatus().toString());
        return result;
    }

    @Override
    public List<SubjectSelectedFinal> getAllSubjectSelectedFinal() {
        return subjectSelectedFinalRepo.findAll();
    }

    @Override
    public Map<String, String> getFinishedStatus(int finalId, int subjectId, int userCurriculumId) {
       Map<String, String> result = new HashMap<>();
        Integer subjectRegisterId = subjectRegisterRepo.findIdBySubjectIdAndUserCurriculumId(subjectId, userCurriculumId);
        SubjectSelectedFinal sb = subjectSelectedFinalRepo.findBySubjectRegisterIdAndFinalId(subjectRegisterId, finalId);
        result.put("status",sb.getExamStatus().toString());
        return result;
    }

    @Override
    public void insert(int subjectRegisterId) {
        SubjectRegister subjectRegister = subjectRegisterRepo.findById(subjectRegisterId).orElseThrow(() -> new RuntimeException("subjectRegister can not be found"));
        SubjectSelectedFinal sb = new SubjectSelectedFinal();
        sb.setAvailabilityStatus(SubjectSelectedFinal.AvailabilityStatus.unable);
        sb.setExamStatus(SubjectSelectedFinal.ExamStatus.unfinished);
        sb.setGrade(BigDecimal.valueOf(0));
        sb.setSubjectRegister(subjectRegister);
        subjectSelectedFinalRepo.save(sb);
    }

    @Override
    public SubjectSelectedFinal getBySubjectRegisterId(int subjectRegisterId) {
        return subjectSelectedFinalRepo.findBySubjectRegisterId(subjectRegisterId);
    }

}
