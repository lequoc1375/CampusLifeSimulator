package com.example.app.service.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.FriendRelationship;
import com.example.app.entity.FriendRequest;
import com.example.app.entity.FriendRequest.RequestStatus;
import com.example.app.entity.User;
import com.example.app.repository.FriendRequestRepo;
import com.example.app.service.serviceInterface.FriendRelationshipService;
import com.example.app.service.serviceInterface.FriendRequestService;

@Service
public class FriendRequestServiceImpl implements FriendRequestService {

    @Autowired
    FriendRequestRepo friendRequestRepo;

    @Autowired
    FriendRelationshipService friendRelationshipService;

    @Override
    public List<FriendRequest> getFriendRequestsByUserId(int user_id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFriendRequestsByUserId'");
    }

    @Override
    public FriendRequest createRequest(User sender, User receiver) {
        FriendRequest friendRequest = new FriendRequest();
        friendRequest.setSender(sender);
        friendRequest.setReceiver(receiver);
        friendRequest.setRequestTime(LocalDateTime.now());
        friendRequest.setStatus(RequestStatus.PENDING);

        return friendRequestRepo.save(friendRequest);
    }

    @Override
    public boolean existsBySender_UserIdAndReceiver_UserId(int senderId, int receiverId) {
        return friendRequestRepo.existsBySender_UserIdAndReceiver_UserId(senderId, receiverId);
    }

    @Override
    public List<FriendRequest> getPendingRequests(int userId) {
        return friendRequestRepo.findByReceiver_UserIdAndStatus(userId, RequestStatus.PENDING);
    }

    @Override
    public void acceptRequest(int requestId) {
        Optional<FriendRequest> optionalRequest = friendRequestRepo.findById(requestId);
        if (optionalRequest.isPresent()) {
            FriendRequest request = optionalRequest.get();
            request.setStatus(RequestStatus.ACCEPTED);
            request.setResponseTime(LocalDateTime.now());
            friendRequestRepo.save(request);

            friendRelationshipService.createRelationship(request.getSender(), request.getReceiver());
            
        } else {
            throw new IllegalArgumentException("Friend request not found");
        }
    }

    @Override
    public void declineRequest(int requestId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'declineRequest'");
    }
    
}
