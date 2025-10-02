package com.example.app.controller.pagecontroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopBackAccessories {
    @GetMapping("/admin/shopBackAccessories/form")
    public String showForm() {
        return "admin/ShopBackAccessories";
    }
}
