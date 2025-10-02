package com.example.app.dto.responseDTO;

import java.util.List;

public class SubjectDTOResponse {
    private int subject_id;
    private String name;
    private int credit;
    private List<LessonDTOResponse> lessons;
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
        return credit;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }
    public List<LessonDTOResponse> getLessons() {
        return lessons;
    }
    public void setLessons(List<LessonDTOResponse> lessons) {
        this.lessons = lessons;
    } 
    

}
