package com.example.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "final_problem")
@NoArgsConstructor
@AllArgsConstructor
public class FinalProblem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer finalProblemId;

    @Column(name = "problem_order")
    private Integer problemOrder;

    @Column(name = "question_image")
    private String questionImage;

    @Column(name = "answer_image")
    private String answerImage;

    @Column(name = "answer")
    private String answer;

    @ManyToOne
    @JoinColumn(name = "final_id", referencedColumnName = "final_id")
    @JsonIgnore
    private FinalExam finalExam;

    public Integer getFinalProblemId() {
        return finalProblemId;
    }

    public void setFinalProblemId(Integer finalProblemId) {
        this.finalProblemId = finalProblemId;
    }

    public Integer getProblemOrder() {
        return problemOrder;
    }

    public void setProblemOrder(Integer problemOrder) {
        this.problemOrder = problemOrder;
    }

    public String getQuestionImage() {
        return questionImage;
    }

    public void setQuestionImage(String questionImage) {
        this.questionImage = questionImage;
    }

    public String getAnswerImage() {
        return answerImage;
    }

    public void setAnswerImage(String answerImage) {
        this.answerImage = answerImage;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public FinalExam getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(FinalExam finalExam) {
        this.finalExam = finalExam;
    }

}
