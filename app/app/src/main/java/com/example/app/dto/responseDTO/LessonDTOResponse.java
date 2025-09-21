package com.example.app.dto.responseDTO;

import java.util.List;

public class LessonDTOResponse {
    private int lessonId;
    private String name;
    private int lesson_order;
    private int length;
    private String link_video;
    private String subject_name;
    private List<ProblemDTOResponse> problem;

    public int getLessonId() {
        return lessonId;
    }

    public List<ProblemDTOResponse> getProblem() {
        return problem;
    }

    public void setProblem(List<ProblemDTOResponse> problem) {
        this.problem = problem;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLesson_order() {
        return lesson_order;
    }

    public void setLesson_order(int lesson_order) {
        this.lesson_order = lesson_order;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getLink_video() {
        return link_video;
    }

    public void setLink_video(String link_video) {
        this.link_video = link_video;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

}
