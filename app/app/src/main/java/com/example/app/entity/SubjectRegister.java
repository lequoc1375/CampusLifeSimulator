package com.example.app.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "subject_register")
public class SubjectRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="subject_register_id")
    private int subject_register_id;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "user_curriculum_id", referencedColumnName = "user_curriculum_id")
    private UserCurriculum userCurriculum;

    @Enumerated(EnumType.STRING)
    @Column(name = "overall")
    private Overall overall;

    @Column(name = "registration_time", nullable = false)
    private LocalDateTime registrationTime;

    public int getSubjectRegisterId() {
        return subject_register_id;
    }

    public void setSubjectRegisterId(int subject_register_id) {
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

    public Overall getOverall() {
        return overall;
    }

    public void setOverall(Overall overall) {
        this.overall = overall;
    }

    public enum Overall {
        pass, fail, studying
    }
    
    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(LocalDateTime registrationTime) {
        this.registrationTime = registrationTime;
    }
}
