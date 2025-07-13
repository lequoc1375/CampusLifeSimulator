package com.example.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jobs")
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Integer jobId;

    @Column(name = "name")
    private String name;

    @Column(name = "energy_affected")
    private Integer energyAffected;

    @Column(name = "stress_affected")
    private Integer stressAffected;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "contract_period")
    private Integer contractPeriod;

    @Column(name = "exp_multiple")
    private Double expMultiple;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEnergyAffected() {
        return energyAffected;
    }

    public void setEnergyAffected(Integer energyAffected) {
        this.energyAffected = energyAffected;
    }

    public Integer getStressAffected() {
        return stressAffected;
    }

    public void setStressAffected(Integer stressAffected) {
        this.stressAffected = stressAffected;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(Integer contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    public Double getExpMultiple() {
        return expMultiple;
    }

    public void setExpMultiple(Double expMultiple) {
        this.expMultiple = expMultiple;
    }
    

}
