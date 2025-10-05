package com.example.app.service.serviceImpl;

import com.example.app.entity.PlayerAvatar;
import com.example.app.repository.PlayerAvatarRepo;
import com.example.app.service.serviceInterface.PlayerAvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerAvatarServiceImpl implements PlayerAvatarService {

    private final PlayerAvatarRepo playerAvatarRepo;

    @Autowired
    public PlayerAvatarServiceImpl(PlayerAvatarRepo playerAvatarRepo) {
        this.playerAvatarRepo = playerAvatarRepo;
    }

    @Override
    public List<PlayerAvatar> getAllAvatars() {
        return playerAvatarRepo.findAll();
    }

    @Override
    public Optional<PlayerAvatar> getAvatarById(int id) {
        return playerAvatarRepo.findById(id);
    }

    @Override
    public PlayerAvatar getAvatarEntityByUserId(int userId) {
        return playerAvatarRepo.findByUser_UserId(userId);
    }


    @Override
    public Optional<PlayerAvatar> getAvatarByUserId(int userId) {
        return Optional.ofNullable(playerAvatarRepo.findByUser_UserId(userId));
    }

    @Override
    public PlayerAvatar createAvatar(PlayerAvatar avatar) {
        return playerAvatarRepo.save(avatar);
    }

    @Override
    public PlayerAvatar updateAvatar(int id, PlayerAvatar updatedAvatar) {
        return playerAvatarRepo.findById(id)
                .map(existing -> {
                    existing.setBaseBody(updatedAvatar.getBaseBody());
                    existing.setClothing(updatedAvatar.getClothing());
                    existing.setAccessories(updatedAvatar.getAccessories());
                    existing.setUser(updatedAvatar.getUser());
                    return playerAvatarRepo.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Avatar not found with id " + id));
    }

    @Override
    public void deleteAvatar(int id) {
        playerAvatarRepo.deleteById(id);
    }
}
