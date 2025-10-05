package com.example.app.controller.pagecontroller.player;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.entity.User;
import com.example.app.service.serviceInterface.UserService;

@Controller
@RequestMapping("/CampusLife")
public class HomePageController {

    private final UserService userService;

    public HomePageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/HomePage")
    public String moveHomePage(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUsername(username);
        model.addAttribute("user", user);
        return "HomePage";
    }

    @GetMapping("/UniversityTown")
    public String moveUniversityTown(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUsername(username);
        model.addAttribute("user", user);
        return "UniversityTown";
    }
}
