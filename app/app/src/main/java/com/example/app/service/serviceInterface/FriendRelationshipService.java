package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.entity.User;

public interface FriendRelationshipService {
    List<User> getFriendsOfUser(int userId); 

    void createRelationship(User player1, User player2);


}
