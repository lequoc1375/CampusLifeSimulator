package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.FriendRelationship;
import com.example.app.entity.User;
import com.example.app.repository.FriendRelationshipRepo;
import com.example.app.service.serviceInterface.FriendRelationshipService;
import com.example.app.service.serviceInterface.RelationshipService;

@Service
public class FriendRelationshipServiceImpl implements FriendRelationshipService {

    @Autowired
    private FriendRelationshipRepo friendRelationshipRepo;

    @Autowired
    private RelationshipService relationshipService;

    @Override
    public void createRelationship(User player1, User player2) {
        FriendRelationship friendRelationship = new FriendRelationship();
        friendRelationship.setFirstUser(player1);
        friendRelationship.setSecondUser(player2);
        friendRelationship.setCurrentPoint(0);
        friendRelationship.setRelationship(relationshipService.getRelationshipById(1));
        
        friendRelationshipRepo.save(friendRelationship);
    }

    @Override
    public List<User> getFriendsOfUser(int userId) {
        List<FriendRelationship> relationships = friendRelationshipRepo.findByFirstUser_UserIdOrSecondUser_UserId(userId, userId);
        
        return relationships.stream()
            .map(rel -> rel.getFirstUser().getUser_id() == userId ? rel.getSecondUser() : rel.getFirstUser())
            .collect(Collectors.toList());
    }

}
