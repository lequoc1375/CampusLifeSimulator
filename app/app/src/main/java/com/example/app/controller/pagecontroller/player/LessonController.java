package com.example.app.controller.pagecontroller.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.app.dto.responseDTO.LessonDTOResponse;
import com.example.app.entity.LessonStudying;
import com.example.app.repository.LessonStudyingRepo;
import com.example.app.service.serviceInterface.LessonService;


@Controller
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @Autowired
    private LessonStudyingRepo lessonStudyingRepo;

    @GetMapping("/lesson/{id}/{subjectId}")
    public String getLesson(@PathVariable int id, @PathVariable int subjectId,  Model model) {
        
        LessonDTOResponse lesson = lessonService.getLessonById(id);
        LessonStudying lessonStudying = lessonStudyingRepo.findByLessonId(id).get();

        String link = lesson.getLink_video();
        String videoId = "";
        if (link != null && link.contains("v=")) {
            videoId = link.split("v=")[1];
            if (videoId.contains("&")) {
                videoId = videoId.substring(0, videoId.indexOf("&"));
            }
        }

        model.addAttribute("lesson", lesson);
        model.addAttribute("videoId", videoId);
        model.addAttribute("subjectId", subjectId);
        model.addAttribute("lessonStudying", lessonStudying);
        return "lesson"; 
    }

    

}
