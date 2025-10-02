package com.example.app.controller.pagecontroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopFrontAccessories {
    @GetMapping("/admin/shopFrontAccessories/form")
    public String showForm() {
        return "admin/ShopFrontAccessories";
    }
}
