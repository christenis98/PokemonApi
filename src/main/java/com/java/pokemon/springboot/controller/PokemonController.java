package com.java.pokemon.springboot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.java.pokemon.springboot.models.PokemonModel;
import com.java.pokemon.springboot.repository.PokemonRepository;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {
    @Autowired
    private PokemonRepository pokemonRepository;

    // Endpoint para crear un nuevo Pokémon
    @PostMapping("/")
    public PokemonModel crearPokemon(@RequestBody PokemonModel pokemon) {
        return pokemonRepository.save(pokemon);
    }

    // Endpoint para obtener todos los Pokémon
    @GetMapping("/")
    public List<PokemonModel> obtenerTodosLosPokemon() {
        return pokemonRepository.findAll();
    }

    // Endpoint para obtener un Pokémon por ID
    @GetMapping("/{id}")
    public Optional<PokemonModel> obtenerPokemonPorId(@PathVariable Long id) {
        return pokemonRepository.findById(id);
    }

    // Endpoint para actualizar un Pokémon
    @PutMapping("/{id}")
    public PokemonModel actualizarPokemon(@PathVariable Long id, @RequestBody PokemonModel pokemonActualizado) {
        return pokemonRepository.findById(id)
            .map(pokemon -> {
                pokemon.setNombre(pokemonActualizado.getNombre());
                pokemon.setTipo(pokemonActualizado.getTipo());
                // Actualiza otros atributos según sea necesario
                return pokemonRepository.save(pokemon);
            })
            .orElse(null);
    }

    // Endpoint para eliminar un Pokémon por ID
    @DeleteMapping("/{id}")
    public void eliminarPokemon(@PathVariable Long id) {
        pokemonRepository.deleteById(id);
    }
    
    // Consulta para obtener Pokémon por nombre de movimiento
    @GetMapping("/movimiento/{nombreMovimiento}")
    public List<PokemonModel> obtenerPokemonPorMovimiento(@PathVariable String nombreMovimiento) {
        return pokemonRepository.findPokemonByMovimiento(nombreMovimiento);
    }
}