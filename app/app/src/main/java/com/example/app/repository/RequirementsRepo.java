package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.Requirements;

public interface RequirementsRepo extends JpaRepository<Requirements, Integer> {

}
