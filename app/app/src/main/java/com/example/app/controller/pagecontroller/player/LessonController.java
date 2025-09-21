package com.example.app.controller.pagecontroller.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.app.dto.responseDTO.LessonDTOResponse;
import com.example.app.service.serviceInterface.LessonService;


@Controller
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @GetMapping("/lesson/{id}/{subjectId}")
    public String getLesson(@PathVariable int id, @PathVariable int subjectId,  Model model) {
        
        LessonDTOResponse lesson = lessonService.getLessonById(id);


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
        return "lesson"; 
    }

    

}
