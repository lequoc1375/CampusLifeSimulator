package com.example.app.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "player_gym_subscription")
public class PlayerGymSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "gym_package_id", nullable = false)
    private GymPackage gymPackage;

    private Boolean active;

    private LocalDateTime startedAt;
    private LocalDateTime expiredAt;
}
