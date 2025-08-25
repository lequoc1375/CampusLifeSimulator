package com.example.app.controller.pagecontroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UpperCloth {
    @GetMapping("/admin/uppercloth/form")
    public String showForm() {
        return "admin/UpperCloth";
    }
    
}
