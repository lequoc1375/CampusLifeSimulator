package com.example.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "user_curriculum")
public class UserCurriculum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_curriculum_id")
    private int userCurriculumId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "gpa")
    private double gpa;  // dùng double/BigDecimal thay vì long, vì MySQL là DECIMAL(3,2)

    @Column(name = "total_credits")
    private int totalCredits;

    // Getters & Setters
    public int getUserCurriculumId() {
        return userCurriculumId;
    }

    public void setUserCurriculumId(int userCurriculumId) {
        this.userCurriculumId = userCurriculumId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }
}
