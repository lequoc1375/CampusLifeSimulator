package com.example.app.controller.restcontroller.player;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.app.dto.requestDTO.FriendRequestDTO;
import com.example.app.entity.FriendRequest;
import com.example.app.entity.User;
import com.example.app.service.serviceInterface.FriendRequestService;
import com.example.app.service.serviceInterface.UserService;

@RestController
@RequestMapping("/player/api/friend-request")
public class FriendRequestRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private FriendRequestService friendRequestService;

    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userService.getUserByUsername(username);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<?> getUserInfo(@PathVariable String username) {
        User currentUser = getCurrentUser();

        if (username.equalsIgnoreCase(currentUser.getUsername())) {
            return ResponseEntity.badRequest().body("You cannot add yourself.");
        }

        try {
            User targetUser = userService.getUserByUsername(username);

            boolean isFriend = friendRequestService.isFriend(currentUser.getUser_id(), targetUser.getUser_id());
            boolean hasReceivedRequest = friendRequestService.existsBySender_UserIdAndReceiver_UserId(targetUser.getUser_id(), currentUser.getUser_id());

            String relation;
            if (isFriend) {
                relation = "friend";
            } else if (hasReceivedRequest) {
                relation = "incoming_request";
            } else {
                relation = "none";
            }

            return ResponseEntity.ok(Map.of(
                "userId", targetUser.getUser_id(),
                "username", targetUser.getUsername(),
                "relation", relation
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("User not found.");
        }
    }

    @GetMapping("/sent")
    public ResponseEntity<?> getSentRequests() {
        User currentUser = getCurrentUser();
        List<FriendRequest> sent = friendRequestService.getSentRequests(currentUser.getUser_id());
        return ResponseEntity.ok(sent);
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendFriendRequest(@RequestBody FriendRequestDTO request) {
        try {
            int receiverId = request.getReceiverId();
            User sender = getCurrentUser();

            if (receiverId == sender.getUser_id()) {
                return ResponseEntity.badRequest().body("This is you, please check again.");
            }

            User receiver = userService.getUserByUserId(receiverId);
            String receiverUsername = receiver.getUsername();

            boolean alreadyExists = friendRequestService.existsBySender_UserIdAndReceiver_UserId(sender.getUser_id(), receiverId);
            if (alreadyExists) {
                return ResponseEntity.badRequest().body("Already sent a request to this username");
            }

            boolean alreadyReceive = friendRequestService.existsBySender_UserIdAndReceiver_UserId(receiverId, sender.getUser_id());
            if (alreadyReceive) {
                FriendRequest existingRequest = friendRequestService
                    .findBySender_UserIdAndReceiver_UserId(receiverId, sender.getUser_id())
                    .orElseThrow(() -> new RuntimeException("Request not found"));

                friendRequestService.acceptRequest(existingRequest.getRequestId());
                return ResponseEntity.ok("Accepted pending request from " + receiverUsername);
            }

            friendRequestService.createRequest(sender, receiver);
            return ResponseEntity.ok("Sent friend request to " + receiverUsername);

        } catch (NullPointerException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid username or ID.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Server error, please try again.");
        }
    }

    @GetMapping("/pending")
    public ResponseEntity<?> getPendingRequests() {
        User currentUser = getCurrentUser();
        List<FriendRequest> pending = friendRequestService.getPendingRequests(currentUser.getUser_id());
        return ResponseEntity.ok(pending);
    }

    @PostMapping("/accept/{requestId}")
    public String acceptFriendRequest(@PathVariable Long requestId) {
        friendRequestService.acceptRequest(requestId);
        return "Friend request accepted";
    }

    @PostMapping("/decline/{requestId}")
    public String declineFriendRequest(@PathVariable Long requestId) {
        friendRequestService.declineRequest(requestId);
        return "Friend request declined";
    }
}
