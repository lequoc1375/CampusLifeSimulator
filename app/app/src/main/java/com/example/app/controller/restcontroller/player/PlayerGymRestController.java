package com.example.app.controller.restcontroller.player;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.dto.responseDTO.GymExerciseDTOResponse;
import com.example.app.dto.responseDTO.GymPackageDTOResponse;
import com.example.app.dto.responseDTO.GymProgressResponseDTO;
import com.example.app.dto.responseDTO.GymSubscriptionResponseDTO;
import com.example.app.entity.PlayerStats;
import com.example.app.entity.User;
import com.example.app.service.serviceImpl.GymTrainingService;
import com.example.app.service.serviceInterface.GymExerciseService;
import com.example.app.service.serviceInterface.GymPackageService;
import com.example.app.service.serviceInterface.GymProgressService;
import com.example.app.service.serviceInterface.GymSubscriptionService;
import com.example.app.service.serviceInterface.PlayerStatsService;
import com.example.app.service.serviceInterface.UserService;

@RestController
@RequestMapping("/player/api/gym")
public class PlayerGymRestController {
    
    @Autowired 
    private GymExerciseService gymExerciseService;
    
    @Autowired 
    private GymProgressService progressService;
    
    @Autowired 
    private GymSubscriptionService subscriptionService;

    @Autowired 
    private GymTrainingService trainingService;
    
    @Autowired 
    private UserService userService;
    
    @Autowired 
    private PlayerStatsService statsService;

    @Autowired
    private GymPackageService gymPackageService;

    @GetMapping("/packages")
    public List<GymPackageDTOResponse> getPackages() {
        return gymPackageService.getAllPackages();
    }

    @GetMapping("/exercise")
    public List<GymExerciseDTOResponse> getAll() {
        return gymExerciseService.getAll();
    }

    @GetMapping("/progress")
    public GymProgressResponseDTO getProgress() {
        return progressService.getProgress(getCurrentUser());
    }

    @GetMapping("/subscription")
    public GymSubscriptionResponseDTO check() {
        return new GymSubscriptionResponseDTO(
                subscriptionService.hasActivePackage(getCurrentUser())
        );
    }

    @PostMapping("/buyPackage/{packageId}")
    public ResponseEntity<?> buy(@PathVariable Integer packageId) {

        User user = getCurrentUser();

        try {
            subscriptionService.buyPackage(user, packageId);

            PlayerStats stats = statsService.getStats(user);

            return ResponseEntity.ok(
                Map.of(
                    "message", "Purchased package successfully!",
                    "money", stats.getMoney()
                )
            );

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(
                Map.of("error", e.getMessage())
            );
        }
    }

    @PostMapping("/train/{id}")
    public ResponseEntity<?> train(@PathVariable Integer id) {
        User user = getCurrentUser();

        try {
            return ResponseEntity.ok(trainingService.train(user, id));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(
                Map.of("error", e.getMessage())
            );
        }
    }

    private User getCurrentUser() {
        String username = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();
        return userService.getUsername(username);
    }
}
