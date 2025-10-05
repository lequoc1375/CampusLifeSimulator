package com.example.app.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.entity.User;
import com.example.app.entity.User.Role;
import com.example.app.repository.UserRepo;
import com.example.app.service.serviceInterface.UserService;

import org.springframework.security.core.Authentication;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PlayerProfileServiceImpl playerProfileServiceImpl;


    @Override
    public User login(String username, String password) {
        User user = userRepo.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public User register(String username, String password) {
        if (userRepo.findByUsername(username) != null) {
            return null;
        }
        User user = new User();

        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        user.setRole(Role.player);
        user.setUsername(username);
        userRepo.save(user);

        return user;
    }

    @Override
    public User getUserByUserId(int userId) {
        return userRepo.findByUserId(userId);
    }

    @Override
    public User getUserByUsername(String username) {
        try {
            return userRepo.findByUsernameIgnoreCase(username);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("User not found with username: " + username);
        }
    }

    @Override
    public String getUsernameByUserId(int userId) {
        return userRepo.findUsernameByUserId(userId);
    }

    @Override
    public User getUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }

        String username = authentication.getName();
        return userRepo.findByUsername(username);
    }
}
