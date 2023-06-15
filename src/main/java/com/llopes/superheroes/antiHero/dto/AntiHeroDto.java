package com.llopes.superheroes.antiHero.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AntiHeroDto {
    private UUID id;

    @NotNull(message = "First Name is required")
    private String firstName;

    private String lastName;

    private String house;

    private String knownAs;
}
