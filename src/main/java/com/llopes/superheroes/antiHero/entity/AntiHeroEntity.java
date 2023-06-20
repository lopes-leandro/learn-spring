package com.llopes.superheroes.antiHero.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.redis.core.RedisHash;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash("AntiHero")
@Data
@Entity
@Table(name = "anti_hero_entity")
@AllArgsConstructor
@NoArgsConstructor
public class AntiHeroEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID id;

    @NotNull(message = "Fist Name is required")
    private String firstName;

    private String lastName;
    
    private String house;
    
    private String knownAs;
    
    private String createdAt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z").format(new Date());
}
