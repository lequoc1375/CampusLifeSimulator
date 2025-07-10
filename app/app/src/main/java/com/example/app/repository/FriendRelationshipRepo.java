package com.example.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.app.entity.FriendRelationship;
import com.example.app.entity.User;

public interface FriendRelationshipRepo extends JpaRepository<FriendRelationship, Integer>{
    List<FriendRelationship> findByFirstUser_UserIdOrSecondUser_UserId(int firstId, int secondId);
}
