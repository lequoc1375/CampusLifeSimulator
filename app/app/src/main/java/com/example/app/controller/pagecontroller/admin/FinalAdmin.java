package com.example.app.controller.pagecontroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FinalAdmin {
    @GetMapping("/admin/final/form")
    public String showForm() {
        return "admin/Final";
    }
    
}
