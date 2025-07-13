package com.example.app.controller.pagecontroller.player;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.util.UserSession;

@Controller
@RequestMapping("/Game")
public class HomePageController {
    @Autowired
    private UserSession userSession;

    @GetMapping("/HomePage")
    public String moveHomePage(Model model) {
        model.addAttribute("user", userSession);
        return "HomePage";
    }

    @GetMapping("/UniversityTown")
    public String moveUniversityTown(Model model) {
        model.addAttribute("user", userSession);
        return "UniversityTown";
    }

}
