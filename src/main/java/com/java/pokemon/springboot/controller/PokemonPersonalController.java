package com.java.pokemon.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.java.pokemon.springboot.models.PokemonPersonal;
import com.java.pokemon.springboot.repository.PokemonPersonalRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pokemonpersonal")
public class PokemonPersonalController {
    @Autowired
    private PokemonPersonalRepository pokemonPersonalRepository;

    // Endpoint para crear un nuevo Pokémon personalizado
    @PostMapping("/")
    public PokemonPersonal crearPokemonPersonal(@RequestBody PokemonPersonal pokemonPersonal) {
        return pokemonPersonalRepository.save(pokemonPersonal);
    }

    // Endpoint para obtener todos los Pokémon personalizados
    @GetMapping("/")
    public List<PokemonPersonal> obtenerTodosLosPokemonPersonal() {
        return pokemonPersonalRepository.findAll();
    }

    // Endpoint para obtener un Pokémon personalizado por ID
    @GetMapping("/{id}")
    public Optional<PokemonPersonal> obtenerPokemonPersonalPorId(@PathVariable Long id) {
        return pokemonPersonalRepository.findById(id);
    }

    // Endpoint para actualizar un Pokémon personalizado
    @PutMapping("/{id}")
    public PokemonPersonal actualizarPokemonPersonal(@PathVariable Long id, @RequestBody PokemonPersonal pokemonPersonalActualizado) {
        return pokemonPersonalRepository.findById(id)
            .map(pokemonPersonal -> {
                pokemonPersonal.setNombre(pokemonPersonalActualizado.getNombre());
                // Actualiza otros atributos según sea necesario
                return pokemonPersonalRepository.save(pokemonPersonal);
            })
            .orElseThrow(null);
    }

    // Endpoint para eliminar un Pokémon personalizado por ID
    @DeleteMapping("/{id}")
    public void eliminarPokemonPersonal(@PathVariable Long id) {
        pokemonPersonalRepository.deleteById(id);
    }
}
