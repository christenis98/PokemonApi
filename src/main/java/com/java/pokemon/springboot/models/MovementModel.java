package com.java.pokemon.springboot.models;

import javax.persistence.*;

@Entity
@Table(name = "movimientos")
public class MovementModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String nombre;
    private int poder;
    private String tipo;
    
	public MovementModel(String nombre, int poder, String tipo) {
		this.nombre = nombre;
		this.poder = poder;
		this.tipo = tipo;
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


}
