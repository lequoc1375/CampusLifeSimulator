package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.app.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
    User findByUsername(String username);

    User findByUserId (int id);

    @Query("SELECT u.username FROM User u WHERE u.userId = :id")
    String findUsernameByUserId(@Param("id") int id);
}
