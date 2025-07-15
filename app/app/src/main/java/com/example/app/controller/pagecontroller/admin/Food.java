package com.example.app.controller.pagecontroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Food {

    @GetMapping("/admin/food/form")
    public String showForm() {
        return "admin/Food";
    }

}
