package com.example.app.dto.requestDTO;

public class ProblemDTORequest {

    private int lesson_id;
    private int problem_order;
    private String question_image;
    private String answer_image;
    private String answer;
    public int getLesson_id() {
        return lesson_id;
    }
    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }
    public int getProblem_order() {
        return problem_order;
    }
    public void setProblem_order(int problem_order) {
        this.problem_order = problem_order;
    }
    public String getQuestion_image() {
        return question_image;
    }
    public void setQuestion_image(String question_image) {
        this.question_image = question_image;
    }
    public String getAnswer_image() {
        return answer_image;
    }
    public void setAnswer_image(String answer_image) {
        this.answer_image = answer_image;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
}
