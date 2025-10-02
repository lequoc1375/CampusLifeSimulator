package com.example.app.controller.restcontroller.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.entity.User;
import com.example.app.service.serviceInterface.FriendRelationshipService;
import com.example.app.service.serviceInterface.UserService;
import com.example.app.util.UserSession;

@RestController
@RequestMapping("/player/api/friend-relationship")
public class FriendRelationshipRestController {

    @Autowired
    private FriendRelationshipService friendRelationshipService;

    @Autowired
    private UserSession userSession;

    @Autowired
    private UserService userService;

    @GetMapping("/list/{userId}")
    public List<User> getFriends(@PathVariable int userId) {
        return friendRelationshipService.getFriendsOfUser(userId);
    }
    
    @DeleteMapping("/remove/{friendId}")
    public ResponseEntity<?> removeFriend(@PathVariable int friendId) {
        friendRelationshipService.removeRelationship(friendId, userSession.getUserId());
        return ResponseEntity.ok().build();
    }

}
