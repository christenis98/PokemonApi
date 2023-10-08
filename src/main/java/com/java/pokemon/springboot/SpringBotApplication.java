package com.java.pokemon.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.java.pokemon.springboot.models.MovementModel;
import com.java.pokemon.springboot.models.PokemonModel;
import com.java.pokemon.springboot.repository.MovementRepository;
import com.java.pokemon.springboot.repository.PokemonRepository;

@SpringBootApplication
@EntityScan(basePackages = "com.java.pokemon.springboot")
public class SpringBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBotApplication.class, args);
    }

    // Inyecta los repositorios necesarios
    private final PokemonRepository pokemonRepository;
    private final MovementRepository movementRepository;

    public SpringBotApplication(PokemonRepository pokemonRepository, MovementRepository movementRepository) {
        this.pokemonRepository = pokemonRepository;
        this.movementRepository = movementRepository;
        
        // Agregar Pokémon de ejemplo
        PokemonModel pikachu = new PokemonModel("Pikachu", "Eléctrico");
        PokemonModel bulbasaur = new PokemonModel("Bulbasaur", "Planta");

        // Guardar los Pokémon en la base de datos
        pokemonRepository.save(pikachu);
        pokemonRepository.save(bulbasaur);

        // Agregar Movimientos de ejemplo
        MovementModel impactrueno = new MovementModel("Impactrueno", 50, "Electrico");
        MovementModel placaje = new MovementModel("Placaje", 40, "Normal");

        // Guardar los Movimientos en la base de datos
        movementRepository.save(impactrueno);
        movementRepository.save(placaje);
    }
	
	

}
