package com.example.app.controller.pagecontroller.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.dto.requestDTO.RegisterDTORequest;
import com.example.app.entity.User;
import com.example.app.service.serviceInterface.PlayerProfileService;
import com.example.app.service.serviceInterface.PlayerStatsService;
import com.example.app.service.serviceInterface.UserService;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @Autowired
    private PlayerProfileService playerProfileService;

    @Autowired
    private PlayerStatsService playerStatsService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("registerDTOrq", new RegisterDTORequest());
        return "Register";
    }

    @PostMapping("/register")
    public String postMethodName(@ModelAttribute RegisterDTORequest registerDTOrq) {
        User user = userService.register(registerDTOrq.getUsername(), registerDTOrq.getPassword());

        if (user == null) {
            return "Register";
        }

        boolean success = playerProfileService.registerProfile(registerDTOrq.getFirstname(),
                registerDTOrq.getLastname(), registerDTOrq.getEmail(), registerDTOrq.getPhone(), user);

        if (!success) {
            return "Register";
        }

        playerStatsService.create(user, 18, 150.0, 100, 100, 100, 0);

        return "redirect:/login";
    }

}
