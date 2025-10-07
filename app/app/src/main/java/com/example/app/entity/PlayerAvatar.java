package com.example.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_avatar")
public class PlayerAvatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_avatar_id")
    private int playerAvatarId;

    @Enumerated(EnumType.STRING)
    @Column(name = "base_body", nullable = false)
    private BaseBody baseBody;

    @ManyToOne
    @JoinColumn(name = "cloth_id")
    private Clothing clothing;

    @ManyToOne
    @JoinColumn(name = "accessory_id")
    private Accessory accessories;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // --- Getters & Setters ---
    public int getPlayerAvatarId() {
        return playerAvatarId;
    }

    public void setPlayerAvatarId(int playerAvatarId) {
        this.playerAvatarId = playerAvatarId;
    }

    public BaseBody getBaseBody() {
        return baseBody;
    }

    public void setBaseBody(BaseBody baseBody) {
        this.baseBody = baseBody;
    }

    public Clothing getClothing() {
        return clothing;
    }

    public void setClothing(Clothing clothing) {
        this.clothing = clothing;
    }

    public Accessory getAccessories() {
        return accessories;
    }

    public void setAccessories(Accessory accessories) {
        this.accessories = accessories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // --- Enum cho cột ENUM('male', 'female') ---
    public enum BaseBody {
        male,
        female
    }
}