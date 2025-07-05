package com.example.app.controller.pagecontroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/admin")
public class LessonAdmin {

    @GetMapping("/lesson/form")
    public String showForm() {
        return "admin/Lesson";
    }
    
    
}
