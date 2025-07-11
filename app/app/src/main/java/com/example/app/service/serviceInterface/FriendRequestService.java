package com.example.app.service.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.example.app.entity.FriendRequest;
import com.example.app.entity.User;

public interface FriendRequestService {
    
    List<FriendRequest> getFriendRequestsByUserId(int user_id);

    FriendRequest createRequest(User sender, User receiver);

    boolean existsBySender_UserIdAndReceiver_UserId(int senderId, int receiverId);

    List<FriendRequest> getPendingRequests(int userId);

    void acceptRequest(Long requestId);

    void declineRequest(Long requestId);

    Optional<FriendRequest> findBySender_UserIdAndReceiver_UserId(int senderId, int receiverId);

}
