package com.example.app.controller.restcontroller.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.dto.responseDTO.PlayerAvatarDTOResponse;
import com.example.app.entity.PlayerAvatar;
import com.example.app.entity.User;
import com.example.app.service.serviceInterface.PlayerAvatarService;
import com.example.app.service.serviceInterface.UserService;

@RestController
@RequestMapping("/player/api/avatar")
public class PlayerAvatarController {

    @Autowired
    private PlayerAvatarService playerAvatarService;

    @Autowired
    private UserService userService;

    @GetMapping("/current")
    public PlayerAvatarDTOResponse getCurrentAvatar() {
        User currentUser = userService.getCurrentUser();
        if (currentUser == null) {
            throw new RuntimeException("User not logged in");
        }
        System.out.println(currentUser.getUserId());
        PlayerAvatar avatar = playerAvatarService.getAvatarEntityByUserId(currentUser.getUserId());
        if (avatar == null) {
            throw new RuntimeException("Avatar not found for user");
        }

        PlayerAvatarDTOResponse response = new PlayerAvatarDTOResponse();
        response.setPlayerAvatarId(avatar.getPlayerAvatarId());
        response.setBaseBody(avatar.getBaseBody().name());

        // ⚙️ TODO: map image URLs từ entity clothing / accessories
        // Giả sử bạn đã liên kết entity Clothing với Upper/Lower/Full/Foot:
        // response.setUpperImageUrl(avatar.getClothing().getUpperCloth().getImageUrl());

        return response;
    }
}