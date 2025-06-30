package com.example.app.service.serviceInterface;

import com.example.app.entity.User;

public interface UserService {
    User login(String username, String password);
}
