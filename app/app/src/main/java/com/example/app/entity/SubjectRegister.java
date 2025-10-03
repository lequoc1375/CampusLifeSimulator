package com.example.app.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "subject_register")
public class SubjectRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_register_id")
    private int subject_register_id;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    @JsonBackReference
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "user_curriculum_id", referencedColumnName = "user_curriculum_id")
    @JsonBackReference
    private UserCurriculum userCurriculum;

    @Column(name = "overall")
    private Double overall;

    @Column(name = "registration_time", nullable = false)
    private LocalDateTime registrationTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @OneToMany(mappedBy = "subjectRegister")
    @JsonManagedReference
    private List<LessonStudying> lessonStudying;

    @OneToOne(mappedBy = "subjectRegister")
    @JsonManagedReference
    private SubjectSelectedMidterm subjectSelectedMidterm;

    @OneToOne(mappedBy = "subjectRegister")
    @JsonManagedReference
    private SubjectSelectedFinal subjectSelectedFinal;

    public SubjectSelectedFinal getSubjectSelectedFinal() {
        return subjectSelectedFinal;
    }

    public void setSubjectSelectedFinal(SubjectSelectedFinal subjectSelectedFinal) {
        this.subjectSelectedFinal = subjectSelectedFinal;
    }

    public enum Status {
        pass, fail, studying
    }

    public int getSubject_register_id() {
        return subject_register_id;
    }

    public void setSubject_register_id(int subject_register_id) {
        this.subject_register_id = subject_register_id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public UserCurriculum getUserCurriculum() {
        return userCurriculum;
    }

    public void setUserCurriculum(UserCurriculum userCurriculum) {
        this.userCurriculum = userCurriculum;
    }

    public Double getOverall() {
        return overall;
    }

    public void setOverall(Double overall) {
        this.overall = overall;
    }

    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(LocalDateTime registrationTime) {
        this.registrationTime = registrationTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<LessonStudying> getLessonStudying() {
        return lessonStudying;
    }

    public void setLessonStudying(List<LessonStudying> lessonStudying) {
        this.lessonStudying = lessonStudying;
    }

    public SubjectSelectedMidterm getSubjectSelectedMidterm() {
        return subjectSelectedMidterm;
    }

    public void setSubjectSelectedMidterm(SubjectSelectedMidterm subjectSelectedMidterm) {
        this.subjectSelectedMidterm = subjectSelectedMidterm;
    }

}
