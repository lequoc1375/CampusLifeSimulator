package com.example.app.dto.responseDTO;

import java.util.List;

import com.example.app.entity.FinalProblem;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
public class FinalDTOResponse {
    private Integer finalId;
    private Integer subjectId;
    private String subject_name;
    private List<FinalProblem> problemList;
    

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    private Integer time;
    private List<FinalProblemDTOResponse> problems;

    public Integer getFinalId() {
        return finalId;
    }

    public void setFinalId(Integer finalId) {
        this.finalId = finalId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public List<FinalProblemDTOResponse> getProblems() {
        return problems;
    }

    public void setProblems(List<FinalProblemDTOResponse> problems) {
        this.problems = problems;
    }

    public List<FinalProblem> getProblemList() {
        return problemList;
    }

    public void setProblemList(List<FinalProblem> problemList) {
        this.problemList = problemList;
    }

}
