package com.java.pokemon.springboot.repository;

import java.util.List;
import java.util.Optional;

import com.java.pokemon.springboot.DTO.PokemonDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.pokemon.springboot.models.PokemonModel;
import com.java.pokemon.springboot.models.MovementModel;

@Repository
public interface PokemonRepository extends JpaRepository<PokemonModel, Long> {
	Optional<PokemonModel> findByNombre(String nombre);
	@Query("SELECT new com.java.pokemon.springboot.DTO.PokemonDTO(pm.id, pm.nombre, pm.tipo) FROM PokemonModel pm JOIN pm.movimientos m WHERE m.nombre = :nombreMovimiento")
	List<PokemonDTO> findPokemonByMovimiento(@Param("nombreMovimiento") String nombreMovimiento);
}
