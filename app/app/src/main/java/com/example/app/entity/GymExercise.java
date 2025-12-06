package com.example.app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "gym_exercise")
public class GymExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gym_exercise_id")
    private Integer gymExerciseId;

    @Column(nullable = false)
    private String name;

    @Column(name = "energy_cost", nullable = false)
    private int energyCost;

    @Column(name = "stress_increase", nullable = false)
    private int stressIncrease;

    @Column(name = "exp_reward", nullable = false)
    private int expReward;

    @Column(name="min_level")
    private Integer minLevel;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "public_id")
    private String publicId;
}
