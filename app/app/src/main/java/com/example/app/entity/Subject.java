package com.example.app.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private int subject_id;

    @Column(name = "name")
    private String name;

    @Column(name = "credits")
    private int credits;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Lesson> lessons = new ArrayList<>();

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Midterm> midterms = new ArrayList<>();

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<FinalExam> finalExams = new ArrayList<>();

    public List<Midterm> getMidterms() {
        return midterms;
    }

    public void setMidterms(List<Midterm> midterms) {
        this.midterms = midterms;
    }

    public List<FinalExam> getFinalExams() {
        return finalExams;
    }

    public void setFinalExams(List<FinalExam> finalExams) {
        this.finalExams = finalExams;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credits;
    }

    public void setCredit(int credits) {
        this.credits = credits;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

}
