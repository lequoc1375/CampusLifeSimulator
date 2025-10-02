package com.example.app.controller.pagecontroller.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.app.dto.requestDTO.LoginDTORequest;
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


    

}
