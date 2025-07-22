package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.entity.User;

public interface FriendRelationshipService {
    List<User> getFriendsOfUser(int userId); 

    void createRelationship(User player1, User player2);

    void removeRelationship(int userId1, int userId2);

    boolean isFriend(int userId1, int userId2);
}
