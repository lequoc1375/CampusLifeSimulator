package com.example.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "final")

@NoArgsConstructor
@AllArgsConstructor
public class FinalExam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "final_id")
    private Integer finalId;

    @Column(name = "time")
    private Integer time;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
     @JsonBackReference
    private Subject subject;

    @OneToMany(mappedBy = "finalExam", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FinalProblem> problems;

    @OneToMany(mappedBy = "finalExam")
    @JsonManagedReference
    private List<SubjectSelectedFinal> subjectSelectedFinals;

    public List<SubjectSelectedFinal> getSubjectSelectedFinals() {
        return subjectSelectedFinals;
    }

    public void setSubjectSelectedFinals(List<SubjectSelectedFinal> subjectSelectedFinals) {
        this.subjectSelectedFinals = subjectSelectedFinals;
    }

    public Integer getFinalId() {
        return finalId;
    }

    public void setFinalId(Integer finalId) {
        this.finalId = finalId;
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

    public List<FinalProblem> getProblems() {
        return problems;
    }

    public void setProblems(List<FinalProblem> problems) {
        this.problems = problems;
    }

}
