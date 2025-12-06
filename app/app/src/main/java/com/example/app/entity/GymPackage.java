package com.example.app.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "gym_package")
@Data
public class GymPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gymPackageId;

    private String packageName;

    private Integer durationDays;

    private BigDecimal price;
}


