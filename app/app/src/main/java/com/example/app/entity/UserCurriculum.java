package com.example.app.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_curriculum")
public class UserCurriculum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="user_curriculum_id")
    private int user_curriculum_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName="user_id")
    private User user;

    @Column(name="gpa")
    private long gpa;

    @Column(name="total_credits")
    private int total_credits;

    public int getUser_curriculum_id() {
        return user_curriculum_id;
    }

    public void setUser_curriculum_id(int user_curriculum_id) {
        this.user_curriculum_id = user_curriculum_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getGpa() {
        return gpa;
    }

    public void setGpa(long gpa) {
        this.gpa = gpa;
    }

    public int getTotal_credits() {
        return total_credits;
    }

    public void setTotal_credits(int total_credits) {
        this.total_credits = total_credits;
    }

    
}
