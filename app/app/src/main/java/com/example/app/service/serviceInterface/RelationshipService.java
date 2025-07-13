package com.example.app.service.serviceInterface;

import com.example.app.entity.Relationship;

public interface RelationshipService {
    void createRelationship(String name, int require_point);
    
    Relationship getRelationshipById(int id);
}
