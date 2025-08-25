package com.example.app.controller.pagecontroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FullCloth {
@GetMapping("/admin/fullcloth/form")
    public String showForm() {
        return "admin/FullCloth";
    }
}
