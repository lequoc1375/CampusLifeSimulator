package com.example.app.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.app.entity.SubjectRegister;
import com.example.app.entity.SubjectSelectedMidterm;
import com.example.app.repository.SubjectSelectedMidtermRepo;
import com.example.app.service.serviceInterface.SubjectSelectedMidtermService;

@EnableScheduling
@Service
public class SchedulerConfig {

    @Autowired
    private SubjectSelectedMidtermService subjectSelectedMidtermService;

    @Autowired
    private SubjectSelectedMidtermRepo subjectSelectedMidtermRepo;

    @Scheduled(cron = "0 0 0 * * *")
    public void autoUpdateMidtermTest() {
        List<SubjectSelectedMidterm> list = subjectSelectedMidtermService.getAllSubjectSelectedMidterm();
        LocalDate now = LocalDate.now();

        for (SubjectSelectedMidterm sb : list) {
            SubjectRegister subRegister = sb.getSubjectRegister();
            if (subRegister != null) {
                LocalDateTime timeRegister = subRegister.getRegistrationTime();
                LocalDate time = timeRegister.toLocalDate();
                SubjectSelectedMidterm.AvailabilityStatus status = sb.getAvailabilityStatus();
                if (status == SubjectSelectedMidterm.AvailabilityStatus.unable) {
                    if (!now.isBefore(time.plusDays(21))) {
                        sb.setAvailabilityStatus(SubjectSelectedMidterm.AvailabilityStatus.able);
                        subjectSelectedMidtermRepo.save(sb);
                    }
                } else if (status == SubjectSelectedMidterm.AvailabilityStatus.able) {
                    if (now.isAfter(time.plusDays(28))) {
                        sb.setAvailabilityStatus(SubjectSelectedMidterm.AvailabilityStatus.unable);
                        subjectSelectedMidtermRepo.save(sb);
                    }
                }
            }
        }
    }

    // Test
    // @Scheduled(fixedRate = 30000) // 30 giây check 1 lần
    // public void autoUpdateMidtermTest() {
    // List<SubjectSelectedMidterm> list =
    // subjectSelectedMidtermService.getAllSubjectSelectedMidterm();
    // LocalDateTime now = LocalDateTime.now();

    // for (SubjectSelectedMidterm sb : list) {
    // SubjectRegister subRegister = sb.getSubjectRegister();
    // if (subRegister != null) {
    // LocalDateTime timeRegister = subRegister.getRegistrationTime();
    // SubjectSelectedMidterm.AvailabilityStatus status =
    // sb.getAvailabilityStatus();
    // SubjectSelectedMidterm.ExamStatus statusExam = sb.getExamStatus();
    // if (status == SubjectSelectedMidterm.AvailabilityStatus.unable && statusExam
    // == SubjectSelectedMidterm.ExamStatus.unfinished) {
    // if (!now.isBefore(timeRegister.plusMinutes(2))) {
    // sb.setAvailabilityStatus(SubjectSelectedMidterm.AvailabilityStatus.able);
    // subjectSelectedMidtermRepo.save(sb);
    // }
    // } else if (status == SubjectSelectedMidterm.AvailabilityStatus.able) {
    // if (now.isAfter(timeRegister.plusMinutes(5))) {
    // sb.setAvailabilityStatus(SubjectSelectedMidterm.AvailabilityStatus.unable);
    // subjectSelectedMidtermRepo.save(sb);
    // }
    // }
    // }
    // }
    // }

}
