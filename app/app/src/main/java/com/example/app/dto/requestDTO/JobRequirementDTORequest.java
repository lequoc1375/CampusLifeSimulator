package com.example.app.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class JobRequirementDTORequest {
    private Integer jobId;
    private Integer requirementId;
    public Integer getJobId() {
        return jobId;
    }
    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }
    public Integer getRequirementId() {
        return requirementId;
    }
    public void setRequirementId(Integer requirementId) {
        this.requirementId = requirementId;
    }
    
}
