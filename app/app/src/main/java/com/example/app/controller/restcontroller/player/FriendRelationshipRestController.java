package com.example.app.controller.restcontroller.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.app.entity.User;
import com.example.app.service.serviceInterface.FriendRelationshipService;
import com.example.app.service.serviceInterface.UserService;

@RestController
@RequestMapping("/player/api/friend-relationship")
public class FriendRelationshipRestController {

    @Autowired
    private FriendRelationshipService friendRelationshipService;

    @Autowired
    private UserService userService;

    private User getCurrentUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null || !authentication.isAuthenticated() 
        || authentication.getPrincipal().equals("anonymousUser")) {
        throw new RuntimeException("User not authenticated");
    }
    String username = authentication.getName();
    return userService.getUserByUsername(username);
}


    @GetMapping("/list/{userId}")
    public ResponseEntity<List<User>> getFriends(@PathVariable int userId) {
        List<User> friends = friendRelationshipService.getFriendsOfUser(userId);
        return ResponseEntity.ok(friends);
    }

    @DeleteMapping("/remove/{friendId}")
    public ResponseEntity<?> removeFriend(@PathVariable int friendId) {
        User currentUser = getCurrentUser();
        friendRelationshipService.removeRelationship(currentUser.getUser_id(), friendId);
        return ResponseEntity.ok("Friend removed successfully.");
    }
}
