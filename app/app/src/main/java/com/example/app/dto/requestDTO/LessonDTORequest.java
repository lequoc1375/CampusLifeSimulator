package com.example.app.dto.requestDTO;

public class LessonDTORequest {
    private String name;
    private int lesson_order;
    private int length;
    private String link_video;
    private int subject_id;
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
    public int getSubject_id() {
        return subject_id;
    }
    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }
    
}
