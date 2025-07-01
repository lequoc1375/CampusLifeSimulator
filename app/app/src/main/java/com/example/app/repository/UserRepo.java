package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.User;

public interface UserRepo extends JpaRepository<User, Object>{
    User findByUsername(String username);
    
}
