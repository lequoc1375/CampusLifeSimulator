package com.example.app.service.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.example.app.dto.requestDTO.FriendRequestNotificationDTORequest;
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

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

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

        FriendRequest savedRequest = friendRequestRepo.save(friendRequest);

        messagingTemplate.convertAndSend(
            "/topic/friend-request/" + receiver.getUser_id(),
            new FriendRequestNotificationDTORequest(sender.getUser_id(), sender.getUsername())
        );

        return savedRequest;
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
    public void acceptRequest(Long requestId) {
        Optional<FriendRequest> optionalRequest = friendRequestRepo.findById(requestId);
        if (optionalRequest.isPresent()) {
            FriendRequest request = optionalRequest.get();
            request.setStatus(RequestStatus.ACCEPTED);
            request.setResponseTime(LocalDateTime.now());
            friendRequestRepo.save(request);

            friendRelationshipService.createRelationship(request.getSender(), request.getReceiver());

            friendRequestRepo.deleteById(requestId);

        } else {
            throw new IllegalArgumentException("Friend request not found");
        }
    }

    @Override
    public void declineRequest(Long requestId) {
    Optional<FriendRequest> optionalRequest = friendRequestRepo.findById(requestId);
    if (optionalRequest.isPresent()) {
        friendRequestRepo.deleteById(requestId);
    } else {
        throw new IllegalArgumentException("Friend request not found");
    }
}


    @Override
    public Optional<FriendRequest> findBySender_UserIdAndReceiver_UserId(int senderId, int receiverId) {
        return friendRequestRepo.findBySender_UserIdAndReceiver_UserId(senderId, receiverId);
    }

    @Override
    public List<FriendRequest> getSentRequests(int userId) {
        return friendRequestRepo.findBySender_UserIdAndStatus(userId, RequestStatus.PENDING);
    }
    
    @Override
    public boolean isFriend(int userId1, int userId2) {
        return friendRelationshipService.isFriend(userId1, userId2)
            || friendRelationshipService.isFriend(userId2, userId1);
    }

}
