package com.example.app.config;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.app.entity.LessonStudying;
import com.example.app.entity.PlayerStats;
import com.example.app.entity.SubjectRegister;
import com.example.app.entity.SubjectSelectedFinal;
import com.example.app.entity.SubjectSelectedMidterm;
import com.example.app.repository.SubjectSelectedFinalRepo;
import com.example.app.repository.SubjectSelectedMidtermRepo;
import com.example.app.service.serviceInterface.LessonStudyingService;
import com.example.app.service.serviceInterface.PlayerStatsService;
import com.example.app.service.serviceInterface.SubjectSelectedFinalService;
import com.example.app.service.serviceInterface.SubjectSelectedMidtermService;

@EnableScheduling
@Service
public class SchedulerConfig {

    @Autowired
    private SubjectSelectedMidtermService subjectSelectedMidtermService;

    @Autowired
    private SubjectSelectedMidtermRepo subjectSelectedMidtermRepo;

    @Autowired
    private LessonStudyingService lessonStudyingService;

    @Autowired
    private PlayerStatsService playerStatsService;

    @Autowired
    private SubjectSelectedFinalRepo subjectSelectedFinalRepo;

    @Autowired
    private SubjectSelectedFinalService subjectSelectedFinalService;
    @Scheduled(cron = "0 0 0 * * *")
    public void autoResetVisitedLesson() {
       List<LessonStudying> list = lessonStudyingService.getAll();
       for(LessonStudying ls : list) {
        ls.setVisited(false);
        lessonStudyingService.save(ls);
       }
       List<PlayerStats> listPlayerStats = playerStatsService.getAll();
       for(PlayerStats ps : listPlayerStats) {
        ps.setCurrentStress(0);
        ps.setCurrentEnergy(ps.getMaxEnergy());
        playerStatsService.save(ps);
       }

    }


    @Scheduled(fixedRate = 5000)
    public void autoUpdateMidtermTest() {
        boolean TEST_MODE = true;
        long OPEN_AFTER_MIN = 4, DURATION_MIN = 4;
        long OPEN_AFTER_DAYS = 21, DURATION_DAYS = 7;

        List<SubjectSelectedMidterm> list = subjectSelectedMidtermService.getAllSubjectSelectedMidterm();
        LocalDateTime now = LocalDateTime.now();

        for (SubjectSelectedMidterm sb : list) {
            SubjectRegister reg = sb.getSubjectRegister();
            if (reg == null)
                continue;
            if (sb.getExamStatus() != SubjectSelectedMidterm.ExamStatus.unfinished)
                continue;

            LocalDateTime regAt = reg.getRegistrationTime();
            if (regAt == null)
                continue;

            LocalDateTime open = TEST_MODE ? regAt.plusMinutes(OPEN_AFTER_MIN) : regAt.plusDays(OPEN_AFTER_DAYS);
            LocalDateTime close = TEST_MODE ? open.plusMinutes(DURATION_MIN) : open.plusDays(DURATION_DAYS);

            SubjectSelectedMidterm.AvailabilityStatus desired;

            if (now.isBefore(open)) {
                desired = SubjectSelectedMidterm.AvailabilityStatus.unable;
            } else if (now.isBefore(close)) {
                desired = SubjectSelectedMidterm.AvailabilityStatus.able;
            } else {
                desired = SubjectSelectedMidterm.AvailabilityStatus.unable;
                sb.setExamStatus(SubjectSelectedMidterm.ExamStatus.finished);
            }

            if (sb.getAvailabilityStatus() != desired) {
                sb.setAvailabilityStatus(desired);
                subjectSelectedMidtermRepo.save(sb);
            }
        }
    }

    @Scheduled(fixedRate = 5000)
    public void autoUpdateFinalTest() {
        boolean TEST_MODE = true;
        long OPEN_AFTER_MIN = 4, DURATION_MIN = 4;
        long OPEN_AFTER_DAYS = 21*2, DURATION_DAYS = 7;

        List<SubjectSelectedFinal> list = subjectSelectedFinalService.getAllSubjectSelectedFinal();
        LocalDateTime now = LocalDateTime.now();

        for (SubjectSelectedFinal sb : list) {
            SubjectRegister reg = sb.getSubjectRegister();
            if (reg == null)
                continue;
            if (sb.getExamStatus() != SubjectSelectedFinal.ExamStatus.unfinished)
                continue;

            LocalDateTime regAt = reg.getRegistrationTime();
            if (regAt == null)
                continue;

            LocalDateTime open = TEST_MODE ? regAt.plusMinutes(OPEN_AFTER_MIN) : regAt.plusDays(OPEN_AFTER_DAYS);
            LocalDateTime close = TEST_MODE ? open.plusMinutes(DURATION_MIN) : open.plusDays(DURATION_DAYS);

            SubjectSelectedFinal.AvailabilityStatus desired;

            if (now.isBefore(open)) {
                desired = SubjectSelectedFinal.AvailabilityStatus.unable;
            } else if (now.isBefore(close)) {
                desired = SubjectSelectedFinal.AvailabilityStatus.able;
            } else {
                desired = SubjectSelectedFinal.AvailabilityStatus.unable;
                sb.setExamStatus(SubjectSelectedFinal.ExamStatus.finished);
            }

            if (sb.getAvailabilityStatus() != desired) {
                sb.setAvailabilityStatus(desired);
                subjectSelectedFinalRepo.save(sb);
            }
        }
    }

}
