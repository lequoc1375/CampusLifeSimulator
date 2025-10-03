package com.example.app.controller.pagecontroller.player;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.security.CustomUserDetails;

@Controller
@RequestMapping("/CampusLife")
public class MenuController {

    @GetMapping("/HomePage")
    public String moveHomePage(@AuthenticationPrincipal CustomUserDetails currentUser, Model model) {
        model.addAttribute("user", currentUser);
        return "HomePage";
    }

    @GetMapping("/UniversityTown")
    public String moveUniversityTown(@AuthenticationPrincipal CustomUserDetails currentUser, Model model) {
        model.addAttribute("user", currentUser);
        return "UniversityTown";
    }

    @GetMapping("/RegisterSubjects")
    public String moveRegisterSubject(@AuthenticationPrincipal CustomUserDetails currentUser, Model model) {
        model.addAttribute("user", currentUser);
        return "RegisterSubjects";   
    }

    @GetMapping("/University")
    public String moveUniversity(@AuthenticationPrincipal CustomUserDetails currentUser, Model model) {
        model.addAttribute("user", currentUser);
        return "UniversityPage";  
    }

    @GetMapping("/Midterm")
    public String moveMidterm(@AuthenticationPrincipal CustomUserDetails currentUser, Model model) {
        model.addAttribute("user", currentUser);
        return "Midterm";  
    }

    @GetMapping("/Final")
    public String moveFinal(@AuthenticationPrincipal CustomUserDetails currentUser, Model model) {
        model.addAttribute("user", currentUser);
        return "Final";  
    }

}

