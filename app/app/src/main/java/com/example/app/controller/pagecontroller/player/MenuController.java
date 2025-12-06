package com.example.app.controller.pagecontroller.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.entity.User;
import com.example.app.security.CustomUserDetails;
import com.example.app.service.serviceInterface.UserService;

@Controller
@RequestMapping("/CampusLife")
public class MenuController {
    @Autowired
    private  UserService userService;


    @ModelAttribute("user")
    public User addUserToModel(@AuthenticationPrincipal CustomUserDetails currentUser) {
        if (currentUser != null) {
            return userService.getUsername(currentUser.getUsername()); 
        }
        return null;
    }

    @GetMapping("/HomePage")
    public String moveHomePage() {
        return "HomePage"; 
    }

    @GetMapping("/UniversityTown")
    public String moveUniversityTown() {
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

    @GetMapping("/Food")
    public String moveFoodPage(@AuthenticationPrincipal CustomUserDetails currentUser, Model model) {
        model.addAttribute("user", currentUser);
        return "FoodPage";  
    }

    @GetMapping("/Gym")
    public String moveGymPage(@AuthenticationPrincipal CustomUserDetails currentUser, Model model) {
        model.addAttribute("user", currentUser);
        return "GymPage";  
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

