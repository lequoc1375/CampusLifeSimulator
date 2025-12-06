package com.example.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.app.entity.FriendRelationship;
import com.example.app.entity.Relationship;

public interface RelationshipRepo extends JpaRepository<Relationship, Integer> {
    Relationship findByRelationshipId (int id);
}
