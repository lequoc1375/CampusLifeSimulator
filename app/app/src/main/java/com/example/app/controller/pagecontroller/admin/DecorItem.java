package com.example.app.controller.pagecontroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DecorItem {
    @GetMapping("/admin/decor-item/form")
    public String showForm() {
        return "admin/DecorItems";
    }
    

}
