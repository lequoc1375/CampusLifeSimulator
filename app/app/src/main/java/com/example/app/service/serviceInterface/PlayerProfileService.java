package com.example.app.service.serviceInterface;

import com.example.app.entity.User;

public interface PlayerProfileService {
    boolean registerProfile(String firstname, String lastname, String gender, String email, String phone, User user);
}