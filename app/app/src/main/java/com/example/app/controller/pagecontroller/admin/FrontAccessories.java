package com.example.app.controller.pagecontroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontAccessories {
    @GetMapping("/admin/frontaccessories/form")
    public String showForm() {
        return "admin/FrontAccessories";
    }
}
