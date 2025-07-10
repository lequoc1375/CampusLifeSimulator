package com.example.app.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.Relationship;
import com.example.app.repository.RelationshipRepo;
import com.example.app.service.serviceInterface.RelationshipService;

@Service
public class RelationshipServiceImpl implements RelationshipService {

    @Autowired
    RelationshipRepo relationshipRepo;

    @Override
    public void createRelationship(String name, int require_point) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createRelationship'");
    }

    @Override
    public Relationship getRelationshipById(int id) {
        return relationshipRepo.findByRelationshipId(id);
    }
    
}
