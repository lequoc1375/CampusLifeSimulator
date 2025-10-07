package com.example.app.service.serviceInterface;

import com.example.app.entity.User;

public interface UserService {
    User login(String username, String password);
    User register(String username, String password);
    User getUserByUserId(int userId);
    User getUserByUsername(String username);
    String getUsernameByUserId(int userId);
    User getUsername(String username);
    User getCurrentUser();
}
