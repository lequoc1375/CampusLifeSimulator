package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.dto.requestDTO.LoginDTORequest;
import com.example.app.entity.User;
import com.example.app.service.serviceInterface.UserService;
import com.example.app.util.UserSession;

@Controller
public class LoginController {

    @Autowired
    private UserSession userSession;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        LoginDTORequest loginDTOrq = new LoginDTORequest();
        model.addAttribute("loginDTOrq", loginDTOrq);
        return "Login";
    }

    @PostMapping("/login")
    public String postMethodName(@ModelAttribute LoginDTORequest loginDTOrq) {
        User user = userService.login(loginDTOrq.getUsername(), loginDTOrq.getPassword());

        if (user == null) {
            return "redirect:/login";
        }
        if (user.getRole() == User.Role.admin) {
            return "redirect:/admin/lesson/form";
        }

        userSession.setUsername(user.getUsername());
        userSession.setRole(user.getRole().toString());
        userSession.setUserId(user.getUser_id());

        return "redirect:/Game/HomePage";
    }

}
