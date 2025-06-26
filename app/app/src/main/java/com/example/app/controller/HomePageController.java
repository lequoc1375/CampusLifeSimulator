package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Game")
public class HomePageController {

    @GetMapping("/HomePage")
    public String moveHomePage(@RequestParam(required = false) String param) {
        return "HomePage";
    }

    @GetMapping("/university")
    public String moveUniversityTown(@RequestParam(required = false) String param) {
        return "UniversityTown";
    }

}
