package com.example.app.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class JobRequirementDTOResponse {
    private Integer jobId;
    private Integer requirementId;
    private String jobName;
    private String requirementName;
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
    public String getJobName() {
        return jobName;
    }
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    public String getRequirementName() {
        return requirementName;
    }
    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }
    
}
