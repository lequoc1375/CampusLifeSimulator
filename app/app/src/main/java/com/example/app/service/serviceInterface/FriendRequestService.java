package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.entity.FriendRequest;
import com.example.app.entity.User;

public interface FriendRequestService {
    
    List<FriendRequest> getFriendRequestsByUserId(int user_id);

    FriendRequest createRequest(User sender, User receiver);

    boolean existsBySender_UserIdAndReceiver_UserId(int senderId, int receiverId);

    List<FriendRequest> getPendingRequests(int userId);

    void acceptRequest(int requestId);

    void declineRequest(int requestId);
}
