package com.llopes.superheroes.antiHero.service;

import java.util.UUID;
import org.springframework.stereotype.Service;

import com.llopes.superheroes.antiHero.entity.AntiHeroEntity;
import com.llopes.superheroes.antiHero.repository.AntiHeroRepository;
import com.llopes.superheroes.exception.NotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AntiHeroService {

    private final AntiHeroRepository repo;

    // public AntiHeroService(AntiHeroRepository repo) {
    // this.repo = repo;
    // }

    public Iterable<AntiHeroEntity> findAllAntiHeroes() {
        return repo.findAll();
    }

    public AntiHeroEntity findAntiHeroById(UUID id) {
        return findOrThrow(id);
    }

    public void removeAntiHeroById(UUID id) {
        repo.deleteById(id);
    }

    public AntiHeroEntity addAntiHero(AntiHeroEntity antiHero) {
        return repo.save(antiHero);
    }

    public void updateAntiHero(UUID id, AntiHeroEntity antiHero) {
        findOrThrow(id);
        repo.save(antiHero);
    }

    private AntiHeroEntity findOrThrow(final UUID id) {
        return repo.findById(id)
            .orElseThrow( () -> new NotFoundException("Anti-hero by id " + id + "was not found."));
    }
}
