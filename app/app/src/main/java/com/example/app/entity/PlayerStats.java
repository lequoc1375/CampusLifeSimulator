package com.example.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_stats")
public class PlayerStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_stats_id")
    private int player_stats_id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Column(name = "age")
    private int age;

    @Column(name = "money")
    private double money;

    @Column(name = "max_energy")
    private int maxEnergy;

    @Column(name = "current_energy")
    private int currentEnergy;

    @Column(name = "max_stress")
    private int maxStress;

    @Column(name = "current_stress")
    private int currentStress;

    // Getters and Setters

    public int getPlayer_stats_id() {
        return player_stats_id;
    }

    public void setPlayer_stats_id(int player_stats_id) {
        this.player_stats_id = player_stats_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public void setCurrentEnergy(int currentEnergy) {
        this.currentEnergy = currentEnergy;
    }

    public int getMaxStress() {
        return maxStress;
    }

    public void setMaxStress(int maxStress) {
        this.maxStress = maxStress;
    }

    public int getCurrentStress() {
        return currentStress;
    }

    public void setCurrentStress(int currentStress) {
        this.currentStress = currentStress;
    }
}
