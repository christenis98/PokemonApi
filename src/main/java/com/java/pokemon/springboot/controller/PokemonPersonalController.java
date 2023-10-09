package com.java.pokemon.springboot.controller;

import com.java.pokemon.springboot.models.PokemonModel;
import com.java.pokemon.springboot.repository.PokemonRepository;
import com.java.pokemon.springboot.service.PokemonPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    private PokemonRepository pokemonRepository;
    private final PokemonPersonalService pokemonPersonalService;
    @Autowired
    public PokemonPersonalController(PokemonPersonalService pokemonPersonalService) {
        this.pokemonPersonalService = pokemonPersonalService;
    }

    // Endpoint para crear un nuevo Pokémon personalizado
    @PostMapping("/")
    public PokemonPersonal crearPokemonPersonal(@RequestBody PokemonPersonal pokemonPersonal) throws Exception {
        // Obtén el PokemonModel al que se hace referencia
        Optional<PokemonModel> pokemonBaseOptional = pokemonRepository.findById(pokemonPersonal.getPokemonBase().getId());

        if (pokemonBaseOptional.isPresent()) {
            // Si el PokemonModel existe, asigna el PokemonModel a PokemonPersonal y guárdalo
            PokemonModel pokemonBase = pokemonBaseOptional.get();
            pokemonPersonal.setPokemonBase(pokemonBase);
            return pokemonPersonalRepository.save(pokemonPersonal);
        }else {
            // Si el PokemonModel no existe, maneja el caso según tu lógica de negocio
            // Puedes lanzar una excepción o crear el PokemonModel si es apropiado.
            // Por ejemplo, puedes lanzar una excepción indicando que el PokemonModel no existe.
            throw new Exception("El pokemon no existe");
        }
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
