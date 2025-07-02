package com.example.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Lesson")
public class Lesson {
    @Id
    private int lesson_id;
    

}
