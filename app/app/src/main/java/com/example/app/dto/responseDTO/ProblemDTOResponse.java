package com.example.app.dto.responseDTO;

public class ProblemDTOResponse {

    private int problem_id;
    private String lesson_name;
    private int problem_order;
    private String question_image;
    private String answer_image;
    private String answer;

    public int getProblem_id() {
        return problem_id;
    }

    public void setProblem_id(int problem_id) {
        this.problem_id = problem_id;
    }
    // public int getLessonId() {
    // return lessonId;
    // }
    // public void setLessonId(int lessonId) {
    // this.lessonId = lessonId;
    // }

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

    public String getLesson_name() {
        return lesson_name;
    }

    public void setLesson_name(String lesson_name) {
        this.lesson_name = lesson_name;
    }

}
