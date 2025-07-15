package com.example.app.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_requirements")
public class JobRequirement {

    @EmbeddedId
    private JobRequirementId id;

    @ManyToOne
    @MapsId("jobId")
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne
    @MapsId("requirementId")
    @JoinColumn(name = "requirement_id")
    private Requirements requirement;

    public JobRequirementId getId() {
        return id;
    }

    public void setId(JobRequirementId id) {
        this.id = id;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Requirements getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirements requirement) {
        this.requirement = requirement;
    }

    public JobRequirement() {
    }

    public JobRequirement(Job job, Requirements requirement) {
        this.job = job;
        this.requirement = requirement;
        this.id = new JobRequirementId(job.getJobId(), requirement.getRequirementId());
    }

}
