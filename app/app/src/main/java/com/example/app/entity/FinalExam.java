package com.example.app.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "final")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FinalExam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer finalId;

    private Integer time;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToMany(mappedBy = "finalExam", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FinalProblem> problems;
}
