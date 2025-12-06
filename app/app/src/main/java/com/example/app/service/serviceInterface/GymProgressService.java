package com.example.app.service.serviceInterface;

import com.example.app.dto.responseDTO.GymProgressResponseDTO;
import com.example.app.entity.User;

public interface GymProgressService {
    GymProgressResponseDTO getProgress(User user);
    GymProgressResponseDTO gainExp(User user, int expGain);
}
