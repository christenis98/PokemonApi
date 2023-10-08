package com.java.pokemon.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.pokemon.springboot.models.PokemonPersonal;

@Repository
public interface PokemonPersonalRepository extends JpaRepository<PokemonPersonal, Long> {
   
}