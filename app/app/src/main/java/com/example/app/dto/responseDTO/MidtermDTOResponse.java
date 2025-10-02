package com.example.app.dto.responseDTO;

import java.util.List;

import com.example.app.entity.MidtermProblem;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class MidtermDTOResponse {
    private Integer midtermId;
    private Integer time;
    private String subject_name;
    private List<MidtermProblem> problems;
    public Integer getMidtermId() {
        return midtermId;
    }
    public void setMidtermId(Integer midtermId) {
        this.midtermId = midtermId;
    }
    public Integer getTime() {
        return time;
    }
    public void setTime(Integer time) {
        this.time = time;
    }
    public String getSubject_name() {
        return subject_name;
    }
    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }
    public List<MidtermProblem> getProblems() {
        return problems;
    }
    public void setProblems(List<MidtermProblem> problems) {
        this.problems = problems;
    }

    
}
