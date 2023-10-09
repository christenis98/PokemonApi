package com.java.pokemon.springboot.DTO;

public class PokemonDTO {
    private Long id;
    private String nombre;
    private String tipo;

    public PokemonDTO() {

    }

    // Constructor con los campos necesarios
    public PokemonDTO(Long id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
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
