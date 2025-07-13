package com.example.app.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class JobRequirementId implements Serializable {

    @Column(name = "job_id")
    private Integer jobId;

    @Column(name = "requirement_id")
    private Integer requirementId;

    public JobRequirementId() {
    }

    public JobRequirementId(Integer jobId, Integer requirementId) {
        this.jobId = jobId;
        this.requirementId = requirementId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof JobRequirementId))
            return false;
        JobRequirementId that = (JobRequirementId) o;
        return Objects.equals(jobId, that.jobId) && Objects.equals(requirementId, that.requirementId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, requirementId);
    }

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
