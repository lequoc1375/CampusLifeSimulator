package com.example.app.controller.restcontroller.player;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.entity.FriendRequest;
import com.example.app.entity.User;
import com.example.app.security.CustomUserDetails;
import com.example.app.service.serviceInterface.FriendRequestService;
import com.example.app.service.serviceInterface.UserService;
import com.example.app.util.UserSession;

@RestController
@RequestMapping("/player/api/friend-request")
public class FriendRequestRestController {

    @Autowired
    private UserSession userSession;

    @Autowired
    private UserService userService;

    @Autowired
    private FriendRequestService friendRequestService;

    @GetMapping("/user/{username}")
    public ResponseEntity<?> getUserInfo(@PathVariable String username,
                                        @AuthenticationPrincipal CustomUserDetails currentUser) {
        int currentUserId = currentUser.getUserId();
        String currentUsername = currentUser.getUsername();

        if (username.equalsIgnoreCase(currentUsername)) {
            return ResponseEntity.badRequest().body("You cannot add yourself.");
        }

        try {
            User user = userService.getUserByUsername(username);

            boolean isFriend = friendRequestService.isFriend(currentUserId, user.getUserId());
            boolean hasReceivedRequest = friendRequestService.existsBySender_UserIdAndReceiver_UserId(user.getUserId(), currentUserId);

            String relation;
            if (isFriend) {
                relation = "friend";
            } else if (hasReceivedRequest) {
                relation = "incoming_request";
            } else {
                relation = "none";
            }

            return ResponseEntity.ok(Map.of(
                    "userId", user.getUserId(),
                    "username", user.getUsername(),
                    "relation", relation
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("User not found.");
        }
    }

    @GetMapping("/sent")
    public ResponseEntity<?> getSentRequests() {
        int userId = userSession.getUserId();
        List<FriendRequest> sent = friendRequestService.getSentRequests(userId);
        return ResponseEntity.ok(sent);
    }
    
    @PostMapping("/send")
    public ResponseEntity<?> sendFriendRequest(@RequestBody Map<String, Object> payload) {
        try {
            int receiverId = (int) payload.get("receiverId");
            int senderId = userSession.getUserId();

            if (receiverId == senderId) {
                return ResponseEntity.badRequest().body("This is you, please check again.");
            }

            User sender = userService.getUserByUserId(senderId);
            User receiver = userService.getUserByUserId(receiverId);

            String receiverUsername = receiver.getUsername();

            boolean alreadyExists = friendRequestService.existsBySender_UserIdAndReceiver_UserId(senderId, receiverId);
            if (alreadyExists) {
                return ResponseEntity.badRequest().body("Already send request to this username");
            }

            boolean alreadyReceive = friendRequestService.existsBySender_UserIdAndReceiver_UserId(receiverId, senderId);
            if (alreadyReceive) {
                FriendRequest existingRequest = friendRequestService
                    .findBySender_UserIdAndReceiver_UserId(receiverId, senderId)
                    .orElseThrow(() -> new RuntimeException("Request not found"));

                friendRequestService.acceptRequest(existingRequest.getRequestId());
                return ResponseEntity.ok("Accepted pending request from " + receiverUsername);
            }


            friendRequestService.createRequest(sender, receiver);
            return ResponseEntity.ok("Sent friend request to " + receiverUsername);

        } catch (NullPointerException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid username.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Server error, please try again.");
        }
    }

    @GetMapping("/pending")
    public ResponseEntity<?> getPendingRequests() {
        int userId = userSession.getUserId();
        List<FriendRequest> pending = friendRequestService.getPendingRequests(userId);
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
