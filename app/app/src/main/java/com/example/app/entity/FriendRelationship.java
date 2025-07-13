package com.example.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="friend_relationship")
public class FriendRelationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long friendRelationshipId;

    @OneToOne
    @JoinColumn(name = "first_user_id", referencedColumnName = "user_id", nullable = false)
    private User firstUser;

    @OneToOne
    @JoinColumn(name = "second_user_id", referencedColumnName = "user_id", nullable = false)
    private User secondUser;

    @OneToOne
    @JoinColumn(name = "relationship_id", referencedColumnName = "relationship_id", nullable = false)
    private Relationship relationship;
    
    @Column(name = "current_point")
    private int currentPoint;

    public long getFriendRelationshipId() {
        return friendRelationshipId;
    }

    public void setFriendRelationshipId(long friendRelationshipId) {
        this.friendRelationshipId = friendRelationshipId;
    }

    public User getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(User firstUser) {
        this.firstUser = firstUser;
    }

    public User getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(User secondUser) {
        this.secondUser = secondUser;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }

    public int getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(int currentPoint) {
        this.currentPoint = currentPoint;
    }

}
