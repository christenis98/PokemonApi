package com.java.pokemon.springboot.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "pokemon_personal")
public class PokemonPersonal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "pokemon_id")
    private PokemonModel pokemonBase;

    @ManyToMany
    @JoinTable(
        name = "pokemon_personal_movimientos",
        joinColumns = @JoinColumn(name = "pokemon_personal_id"),
        inverseJoinColumns = @JoinColumn(name = "movement_id")
    )
    private List<MovementModel> movimientos;

    public void addMovement(MovementModel movement) {
        if (movimientos == null) {
            movimientos = new ArrayList<>();
        }
        movimientos.add(movement);
        movement.getPokemonPersonales().add(this); // Establecer la referencia bidireccional
    }

    public PokemonPersonal() {

    }
    public PokemonPersonal(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public PokemonModel getPokemonBase() {
        return pokemonBase;
    }

    public void setPokemonBase(PokemonModel pokemonBase) {
        this.pokemonBase = pokemonBase;
    }

    public List<MovementModel> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<MovementModel> movimientos) {
        this.movimientos = movimientos;
    }
}
