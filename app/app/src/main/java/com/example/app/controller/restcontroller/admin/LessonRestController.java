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

import com.example.app.dto.requestDTO.LessonDTORequest;
import com.example.app.dto.responseDTO.LessonDTOResponse;
import com.example.app.service.serviceInterface.LessonService;

@RestController
@RequestMapping("admin/api")
public class LessonRestController {

    @Autowired
    private LessonService lessonService;

    @PostMapping("/lesson/add")
    public void insertNewLesson(@RequestBody LessonDTORequest lesson) {
        lessonService.createLesson(lesson);
    }

    @GetMapping("/lessons/list")
    public List<LessonDTOResponse> listAllLesson() {
        return lessonService.getAllLessons();
    }

    @DeleteMapping("/lesson/delete/{lessonId}")
    public void deleteLesson(@PathVariable int lessonId) {
        lessonService.deleteLesson(lessonId);
    }

    @PutMapping("/lesson/update/{lessonId}")
    public void postMethodName(@RequestBody LessonDTORequest lesson, @PathVariable int lessonId) {
       lessonService.updateLesson(lessonId, lesson);
    }
    

}
