package com.java.pokemon.springboot.service;

import com.java.pokemon.springboot.models.MovementModel;
import com.java.pokemon.springboot.models.PokemonPersonal;
import com.java.pokemon.springboot.repository.MovementRepository;
import com.java.pokemon.springboot.repository.PokemonPersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonPersonalService {
    private final PokemonPersonalRepository pokemonPersonalRepository;
    private final MovementRepository movementModelRepository;

    @Autowired
    public PokemonPersonalService(
            PokemonPersonalRepository pokemonPersonalRepository,
            MovementRepository movementModelRepository
    ) {
        this.pokemonPersonalRepository = pokemonPersonalRepository;
        this.movementModelRepository = movementModelRepository;
    }

    public PokemonPersonal guardarPokemonPersonal(PokemonPersonal pokemonPersonal) {
        // Guardar primero las instancias de MovementModel
        for (MovementModel movimiento : pokemonPersonal.getMovimientos()) {
            movementModelRepository.save(movimiento);
        }

        // Luego guardar PokemonPersonal
        return pokemonPersonalRepository.save(pokemonPersonal);
    }
}
