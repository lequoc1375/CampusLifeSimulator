package com.example.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "final_problem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FinalProblem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer finalProblemId;

    private Integer problemOrder;

    private String questionImage;

    private String answerImage;

    private String answer;

    @ManyToOne
    @JoinColumn(name = "final_id")
    private FinalExam finalExam;
}
