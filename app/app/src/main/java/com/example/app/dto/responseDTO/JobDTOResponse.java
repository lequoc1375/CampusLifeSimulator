package com.example.app.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class JobDTOResponse {
    private Integer jobId;
    private String name;
    private Integer energyAffected;
    private Integer stressAffected;
    private Integer salary;
    private Integer contractPeriod;
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
