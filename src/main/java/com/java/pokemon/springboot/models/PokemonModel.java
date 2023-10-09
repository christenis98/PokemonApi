package com.java.pokemon.springboot.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pokemon")
public class PokemonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipo;

	@OneToMany(mappedBy = "pokemon")
	private List<MovementModel> movimientos;
	public PokemonModel() {

	}
	public PokemonModel( String nombre, String tipo) {

		this.nombre = nombre;
		this.tipo = tipo;
	}

	public void addMovement(MovementModel movement) {
		if (movimientos == null) {
			movimientos = new ArrayList<>();
		}
		movimientos.add(movement);
		movement.setPokemon(this); // Establecer la referencia bidireccional
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
