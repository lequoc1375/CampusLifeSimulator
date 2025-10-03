package com.example.app.entity;

import java.math.BigDecimal;

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
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "subject_selected_final")
public class SubjectSelectedFinal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_selected_final_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "final_id", nullable = false)
    @JsonBackReference
    private FinalExam finalExam;

    @OneToOne
    @JoinColumn(name = "subject_register_id", nullable = false)
    @JsonBackReference
    private SubjectRegister subjectRegister;

    @Column(name = "grade", precision = 5, scale = 2)
    private BigDecimal grade;

    @Enumerated(EnumType.STRING)
    @Column(name = "availability_status", nullable = false)
    private AvailabilityStatus availabilityStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FinalExam getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(FinalExam finalExam) {
        this.finalExam = finalExam;
    }

    public SubjectRegister getSubjectRegister() {
        return subjectRegister;
    }

    public void setSubjectRegister(SubjectRegister subjectRegister) {
        this.subjectRegister = subjectRegister;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public AvailabilityStatus getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(AvailabilityStatus availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public ExamStatus getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(ExamStatus examStatus) {
        this.examStatus = examStatus;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "exam_status", nullable = false)
    private ExamStatus examStatus;

    @Version
    @Column(name = "version")
    private Long version;

    public enum AvailabilityStatus {
        able, unable
    }

    public enum ExamStatus {
        finished, unfinished
    }
    
}
