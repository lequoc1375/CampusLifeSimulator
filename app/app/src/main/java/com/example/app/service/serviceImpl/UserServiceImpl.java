package com.example.app.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.User;
import com.example.app.entity.User.Role;
import com.example.app.repository.UserRepo;
import com.example.app.service.serviceInterface.UserService;

@Service
public class UserServiceImpl implements UserService {

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
        
        user.setPassword(password);
        user.setRole(Role.player);
        user.setUsername(username);
        userRepo.save(user);

        return user;
    }
}
