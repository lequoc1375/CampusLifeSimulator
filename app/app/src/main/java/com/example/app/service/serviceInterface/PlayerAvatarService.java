package com.example.app.service.serviceInterface;

import com.example.app.entity.PlayerAvatar;
import java.util.List;
import java.util.Optional;

public interface PlayerAvatarService {

    List<PlayerAvatar> getAllAvatars();

    Optional<PlayerAvatar> getAvatarById(int id);

    Optional<PlayerAvatar> getAvatarByUserId(int userId);

    PlayerAvatar createAvatar(PlayerAvatar avatar);

    PlayerAvatar updateAvatar(int id, PlayerAvatar updatedAvatar);

    void deleteAvatar(int id);

    PlayerAvatar getAvatarEntityByUserId(int userId);

}