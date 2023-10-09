package com.java.pokemon.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.pokemon.springboot.models.PokemonModel;

@Repository
public interface PokemonRepository extends JpaRepository<PokemonModel, Long> {

	/*@Query("SELECT pm FROM PokemonModel pm JOIN pm.movimientos m WHERE m.nombre = :nombreMovimiento")
	List<PokemonModel> findPokemonByMovimiento(@Param("nombreMovimiento") String nombreMovimiento);*/
}
