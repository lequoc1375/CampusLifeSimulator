package com.example.app.dto.requestDTO;

public class ProblemSubmissionDTO {
    private int problem_order;
    private String answer;

    public int getProblem_order() {
        return problem_order;
    }

    public void setProblem_order(int problem_order) {
        this.problem_order = problem_order;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

