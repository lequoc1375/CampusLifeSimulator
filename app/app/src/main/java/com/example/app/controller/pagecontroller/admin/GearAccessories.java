package com.example.app.controller.pagecontroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GearAccessories {
    @GetMapping("/admin/gearaccessories/form")
    public String showForm() {
        return "admin/GearAccessories";
    }
}
