package com.example.app.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.PlayerProfile;
import com.example.app.entity.User;
import com.example.app.repository.PlayerProfileRepo;
import com.example.app.service.serviceInterface.PlayerProfileService;


@Service
public class PlayerProfileServiceImpl implements PlayerProfileService {
    @Autowired
    PlayerProfileRepo playerProfileRepo;

    @Override
    public boolean registerProfile(String firstname, String lastname, String email, String phone, User user) {
        if(playerProfileRepo.findByEmail(email) != null || playerProfileRepo.findByPhone(phone) != null) {
            return false;
        }

        PlayerProfile playerProfile = new PlayerProfile();
        playerProfile.setFirstname(firstname);
        playerProfile.setLastname(lastname);
        playerProfile.setPhone(phone);
        playerProfile.setEmail(email);
        playerProfile.setUser(user);

        playerProfileRepo.save(playerProfile);

        return true;
    }
    
}
