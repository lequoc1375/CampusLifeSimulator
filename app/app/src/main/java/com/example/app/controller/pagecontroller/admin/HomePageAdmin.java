package com.example.app.controller.pagecontroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomePageAdmin {

    @GetMapping("/admin/HomePage")
    public String getMethodName() {
        return "admin/DashboardAdmin";
    }
    

}
