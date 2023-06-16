package com.llopes.superheroes.antiHero.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.llopes.superheroes.antiHero.dto.AntiHeroDto;
import com.llopes.superheroes.antiHero.entity.AntiHeroEntity;
import com.llopes.superheroes.antiHero.service.AntiHeroService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/anti-heroes")
public class AntiHeroController {

    private final ModelMapper mapper;
    private final AntiHeroService antiHeroService;

    @GetMapping("/{id}")
    public AntiHeroDto getAntiHeroById(@PathVariable("id") UUID id) {
        return convertToDto(antiHeroService.findAntiHeroById(id));
    }

    @PostMapping
    public AntiHeroDto postAntiHero(@Valid @RequestBody AntiHeroDto dto) {
        var entity = convertToEntity(dto);
        var antiHero = antiHeroService.addAntiHero(entity);
        return convertToDto(antiHero);
    }

    @PutMapping("/{id}")
    public void putAntiHero(@PathVariable("id") UUID id, @Valid @RequestBody AntiHeroDto dto) {
        if (!id.equals(dto.getId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id does not match.");
        var entity = convertToEntity(dto);
        antiHeroService.updateAntiHero(id, entity);
    }

    @DeleteMapping("/{id}")
    public void deleteAntiHeroById(@PathVariable("id") UUID id) {
        antiHeroService.removeAntiHeroById(id);
    }

    @GetMapping
    public List<AntiHeroDto> getAntiHeroes() {
        var stream = StreamSupport
                .stream(this.antiHeroService.findAllAntiHeroes().spliterator(), false)
                .collect(Collectors.toList());
        return stream
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private AntiHeroDto convertToDto(AntiHeroEntity entity) {
        return mapper.map(entity, AntiHeroDto.class);
    }

    private AntiHeroEntity convertToEntity(AntiHeroDto dto) {
        return mapper.map(dto, AntiHeroEntity.class);
    }
}
