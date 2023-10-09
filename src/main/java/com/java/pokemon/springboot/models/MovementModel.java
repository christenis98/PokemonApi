package com.java.pokemon.springboot.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movimientos")
public class MovementModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String nombre;
    private int poder;
    private String tipo;
	@ManyToOne
	@JoinColumn(name = "pokemon_id")
	private PokemonModel pokemon;

	@ManyToMany(mappedBy = "movimientos")
	private List<PokemonPersonal> pokemonPersonales;

	public MovementModel() {

	}
	public MovementModel(String nombre, int poder, String tipo) {
		this.nombre = nombre;
		this.poder = poder;
		this.tipo = tipo;
	}

	public MovementModel(String nombre, int poder) {
		this.nombre = nombre;
		this.poder = poder;
		this.tipo = null;
	}
	public void addPokemonPersonal(PokemonPersonal pokemonPersonal) {
		if (pokemonPersonales == null) {
			pokemonPersonales = new ArrayList<>();
		}
		pokemonPersonales.add(pokemonPersonal);
		pokemonPersonal.getMovimientos().add(this); // Establecer la referencia bidireccional
	}

	public List<PokemonPersonal> getPokemonPersonales() {
		return pokemonPersonales;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPoder() {
		return poder;
	}

	public void setPoder(int poder) {
		this.poder = poder;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setPokemon(PokemonModel pokemon) {
		this.pokemon = pokemon;
	}
}
