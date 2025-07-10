package com.example.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.FriendRequest;
import com.example.app.entity.FriendRequest.RequestStatus;

public interface FriendRequestRepo extends JpaRepository<FriendRequest, Integer> {
    List<FriendRequest> findBySender_UserId(int senderId);

    List<FriendRequest> findByReceiver_UserId(int receiverId);

    Optional<FriendRequest> findBySender_UserIdAndReceiver_UserId(int senderId, int receiverId);

    boolean existsBySender_UserIdAndReceiver_UserId(int senderId, int receiverId);

    List<FriendRequest> findByReceiver_UserIdAndStatus(int receiverId, RequestStatus status);
}

