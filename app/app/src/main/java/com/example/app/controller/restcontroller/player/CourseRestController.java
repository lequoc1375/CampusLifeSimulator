package com.example.app.controller.restcontroller.player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.entity.Subject;
import com.example.app.service.serviceInterface.LessonStudyingService;
import com.example.app.service.serviceInterface.PlayerStatsService;
import com.example.app.service.serviceInterface.SubjectSelectedMidtermService;
import com.example.app.service.serviceInterface.SubjectService;
import com.example.app.service.serviceInterface.UserCurriculumService;

@RestController
@RequestMapping("/player/api/course")
public class CourseRestController {

    @Autowired
    private PlayerStatsService playerStatsService;
    
    @Autowired
    private SubjectService subjectService;

    @Autowired
    private UserCurriculumService userCurriculumService;

    @Autowired
    private LessonStudyingService lessonStudyingService;

    @Autowired
    private SubjectSelectedMidtermService subjectSelectedMidtermService;
    @GetMapping("/list/{userId}")
    public Map<String, Object> getCourses(@PathVariable int userId) {
        Map<String, Object> result = new HashMap<>();

        List<Subject> inProgress = subjectService.getInProgressSubjectsByUserId(userId);
        List<Subject> notEnrolled = subjectService.getUnregisteredSubjectsByUserId(userId);
        List<Subject> completed = subjectService.getCompletedSubjectsByUserId(userId);

        result.put("inProgress", inProgress);
        result.put("notEnrolled", notEnrolled);
        result.put("completed", completed);

        return result;
    }

    @PostMapping("/register/{userId}/{subjectId}")
    public String registerCourse(@PathVariable int userId, @PathVariable int subjectId, @RequestBody Map<String, List<Integer>> payload) {
        Integer subjectRegisterId = subjectService.registerSubjectForUser(userCurriculumService.getCurriculumIdByUserId(userId), subjectId);
        List<Integer> lessonIds = payload.getOrDefault("lessons", List.of()); 
        lessonStudyingService.insert(userId, lessonIds, subjectRegisterId);
        subjectSelectedMidtermService.insert(subjectRegisterId);
        playerStatsService.updateEnergy(userId, -5);
        return "Registered subject " + subjectId + " for curriculum " + userCurriculumService.getCurriculumIdByUserId(userId);
    }


}
