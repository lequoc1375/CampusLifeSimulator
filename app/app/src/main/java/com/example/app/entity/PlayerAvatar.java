package com.example.app.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="player_avatar")
public class PlayerAvatar {

    @Id
    private int player_avatar_id;

    @Column(name = "cloth_id")
    private int cloth_id;

    @Column(name = "accessory_id")
    private int accessory_id;

    @Column(name = "color")
    private String color;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public int getPlayer_avatar_id() {
        return player_avatar_id;
    }

    public void setPlayer_avatar_id(int player_avatar_id) {
        this.player_avatar_id = player_avatar_id;
    }

    public int getCloth_id() {
        return cloth_id;
    }

    public void setCloth_id(int cloth_id) {
        this.cloth_id = cloth_id;
    }

    public int getAccessory_id() {
        return accessory_id;
    }

    public void setAccessory_id(int accessory_id) {
        this.accessory_id = accessory_id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
}
