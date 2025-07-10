package com.example.app.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "midterm")
@NoArgsConstructor
@AllArgsConstructor
public class Midterm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "midterm_id")
    private Integer midtermId;

    @Column(name = "time")
    private Integer time;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private Subject subject;

    @OneToMany(mappedBy = "midterm", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MidtermProblem> problems;

    public Integer getMidtermId() {
        return midtermId;
    }

    public void setMidtermId(Integer midtermId) {
        this.midtermId = midtermId;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<MidtermProblem> getProblems() {
        return problems;
    }

    public void setProblems(List<MidtermProblem> problems) {
        this.problems = problems;
    }

}
