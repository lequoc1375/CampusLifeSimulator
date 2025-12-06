package com.example.app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "gym_progress")
public class GymProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_gym_progress_id")
    private Integer playerGymProgressId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private Integer lv = 1;

    @Column(nullable = false)
    private Integer exp = 0;

    @Column(name = "exp_to_next_lv", nullable = false)
    private Integer expToNextLv = 100;

    @Transient
    private boolean levelUp;
}
