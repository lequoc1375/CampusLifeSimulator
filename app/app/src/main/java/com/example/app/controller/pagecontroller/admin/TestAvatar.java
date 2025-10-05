package com.example.app.controller.pagecontroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TestAvatar {
    @GetMapping("/admin/avatar/form")
    public String showForm() {
        return "admin/AdminTestAvatar";
    }
    
}
