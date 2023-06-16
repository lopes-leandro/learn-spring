package com.llopes.superheroes.antiHero.repository;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

import com.llopes.superheroes.antiHero.entity.AntiHeroEntity;

public interface AntiHeroRepository extends CrudRepository<AntiHeroEntity, UUID>{
    
}
