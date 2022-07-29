package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Wood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean coniferous;

    private String colour;

    private String name;

    private int age;

    private int weight;

    private boolean artificial;

    private boolean soft;

    public Wood(boolean coniferous, String colour, String name, int age, int weight, boolean artificial, boolean soft) {
        super();
        this.coniferous = coniferous;
        this.colour = colour;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.artificial = artificial;
        this.soft = soft;
    }

}