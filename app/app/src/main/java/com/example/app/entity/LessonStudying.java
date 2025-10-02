package com.example.app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class LessonStudying {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_studying_id")
    private int lesson_studying_id;

    @Column(name = "availability_status")
    @Enumerated(EnumType.STRING)
    private AvailabilityStatus avaiStatus;

    public enum AvailabilityStatus {
        able, unable
    }

    @Column(name = "study_status")
    @Enumerated(EnumType.STRING)
    private StudyStatus studyStatus;

    public enum StudyStatus {
        finished, unfinished
    }

    @OneToOne
    @JoinColumn(name = "lessonId")
    @JsonBackReference
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "subject_register_id", referencedColumnName = "subject_register_id")
    @JsonBackReference
    private SubjectRegister subjectRegister;

    @Column(name = "video_status")
    @Enumerated(EnumType.STRING)
    private VideoStatus videoStatus;

    @Column(name = "score")
    private int score;

    @Column(name = "visited")
    private boolean visited;

    public enum VideoStatus {
        finished, unfinished
    }

    public int getLesson_studying_id() {
        return lesson_studying_id;
    }

    public void setLesson_studying_id(int lesson_studying_id) {
        this.lesson_studying_id = lesson_studying_id;
    }

    public AvailabilityStatus getAvaiStatus() {
        return avaiStatus;
    }

    public void setAvaiStatus(AvailabilityStatus avaiStatus) {
        this.avaiStatus = avaiStatus;
    }

    public StudyStatus getStudyStatus() {
        return studyStatus;
    }

    public void setStudyStatus(StudyStatus studyStatus) {
        this.studyStatus = studyStatus;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public SubjectRegister getSubjectRegister() {
        return subjectRegister;
    }

    public void setSubjectRegister(SubjectRegister subjectRegister) {
        this.subjectRegister = subjectRegister;
    }

    public VideoStatus getVideoStatus() {
        return videoStatus;
    }

    public void setVideoStatus(VideoStatus videoStatus) {
        this.videoStatus = videoStatus;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

}
