package com.example.app.controller.pagecontroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MidtermProblemAdmin {
    @GetMapping("/admin/midterm-problem/form")
    public String showForm() {
        return "admin/MidtermProblemAdmin";
    }
    
}   
