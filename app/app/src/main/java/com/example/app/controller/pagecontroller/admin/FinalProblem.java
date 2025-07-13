package com.example.app.controller.pagecontroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FinalProblem {
    @GetMapping("/admin/final-problem/form")
    public String showForm() {
        return "admin/FinalProblemAdmin";
    }

}
