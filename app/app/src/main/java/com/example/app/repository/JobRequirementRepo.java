package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.JobRequirement;
import com.example.app.entity.JobRequirementId;

public interface JobRequirementRepo extends JpaRepository<JobRequirement, JobRequirementId> {

}
