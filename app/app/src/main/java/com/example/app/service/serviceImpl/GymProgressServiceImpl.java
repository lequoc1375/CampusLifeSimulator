package com.example.app.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.GymProgressMapper;
import com.example.app.dto.responseDTO.GymProgressResponseDTO;
import com.example.app.entity.GymProgress;
import com.example.app.entity.User;
import com.example.app.repository.GymProgressRepo;
import com.example.app.service.serviceInterface.GymProgressService;

@Service
public class GymProgressServiceImpl implements GymProgressService {

    @Autowired
    private GymProgressRepo progressRepo;

    @Autowired
    private GymProgressMapper mapper;

    @Override
    public GymProgressResponseDTO getProgress(User user) {

        GymProgress progress = progressRepo.findByUser(user)
            .orElseGet(() -> {

                GymProgress p = new GymProgress();
                p.setUser(user);
                p.setLv(1);
                p.setExp(0);
                p.setExpToNextLv(100);

                return progressRepo.save(p);
            });

        GymProgressResponseDTO dto = mapper.toResponseDTO(progress);
        dto.setLevelUp(false);
        return dto;
    }

    @Override
    public GymProgressResponseDTO gainExp(User user, int expGain) {

        GymProgress p = progressRepo.findByUser(user).orElseThrow();

        p.setExp(p.getExp() + expGain);

        boolean levelUp = false;

        while (p.getExp() >= p.getExpToNextLv()) {
            p.setExp(p.getExp() - p.getExpToNextLv());
            p.setLv(p.getLv() + 1);
            p.setExpToNextLv((int) (p.getExpToNextLv() * 1.2));
            levelUp = true;
        }

        progressRepo.save(p);

        GymProgressResponseDTO dto = mapper.toResponseDTO(p);
        dto.setLevelUp(levelUp);

        return dto;
    }

}
