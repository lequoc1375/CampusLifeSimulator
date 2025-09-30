package com.example.app.dto.responseDTO;

import java.math.BigDecimal;

public class SubjectSelectedMidtermDTOResponse {

    private Integer id;
    private Integer midtermId;
    private Integer subjectRegisterId;
    private BigDecimal grade;
    private AvailabilityStatus availabilityStatus;
    private ExamStatus examStatus;

    public enum AvailabilityStatus {
        able, unable
    }

    public enum ExamStatus {
        finished, unfinished
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMidtermId() {
        return midtermId;
    }

    public void setMidtermId(Integer midtermId) {
        this.midtermId = midtermId;
    }

    public Integer getSubjectRegisterId() {
        return subjectRegisterId;
    }

    public void setSubjectRegisterId(Integer subjectRegisterId) {
        this.subjectRegisterId = subjectRegisterId;
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
    

}
