package com.example.app.service.serviceInterface;

import com.example.app.entity.User;

public interface GymSubscriptionService {
    boolean hasActivePackage(User user);
    void buyPackage(User user, Integer packageId);
}
