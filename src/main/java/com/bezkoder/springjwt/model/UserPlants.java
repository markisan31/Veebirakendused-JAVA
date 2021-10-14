package com.bezkoder.springjwt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "users_plants")
public class UserPlants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "plant_id")
    @JsonIgnore
    private Long plantId;

    @Column(name = "user_id")
    @JsonIgnore
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "created_at")
    @JsonIgnore
    private Instant createdAt = Instant.now();

    @Column(name = "next_watering")
    private Instant next_watering;

    @Column(name = "are_watered")
    private boolean areWatered = false;
}
