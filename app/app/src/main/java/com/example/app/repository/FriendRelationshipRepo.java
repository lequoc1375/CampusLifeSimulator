package com.example.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.app.entity.FriendRelationship;
import com.example.app.entity.User;

public interface FriendRelationshipRepo extends JpaRepository<FriendRelationship, Integer>{
    List<FriendRelationship> findByFirstUser_UserIdOrSecondUser_UserId(int firstId, int secondId);

    @Query("SELECT fr FROM FriendRelationship fr WHERE " +
        "(fr.firstUser.userId = :userId1 AND fr.secondUser.userId = :userId2) OR " +
        "(fr.firstUser.userId = :userId2 AND fr.secondUser.userId = :userId1)")
    Optional<FriendRelationship> findRelationship(int userId1, int userId2);

    boolean existsByFirstUser_UserIdAndSecondUser_UserId(int userId1, int userId2);
    
}
