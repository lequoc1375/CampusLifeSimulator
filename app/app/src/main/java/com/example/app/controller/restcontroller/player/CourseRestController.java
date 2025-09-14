package com.example.app.controller.restcontroller.player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.app.entity.Subject;
import com.example.app.service.serviceInterface.SubjectService;
import com.example.app.service.serviceInterface.UserCurriculumService;

@RestController
@RequestMapping("/player/api/course")
public class CourseRestController {
    
    @Autowired
    private SubjectService subjectService;

    @Autowired
    private UserCurriculumService userCurriculumService;

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
    public String registerCourse(@PathVariable int userId, @PathVariable int subjectId) {
        subjectService.registerSubjectForUser(userCurriculumService.getCurriculumIdByUserId(userId), subjectId);
        return "Registered subject " + subjectId + " for curriculum " + userCurriculumService.getCurriculumIdByUserId(userId);
    }

}
