package com.java.pokemon.springboot;
import com.java.pokemon.springboot.models.PokemonPersonal;
import com.java.pokemon.springboot.repository.PokemonPersonalRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.java.pokemon.springboot.models.MovementModel;
import com.java.pokemon.springboot.models.PokemonModel;
import com.java.pokemon.springboot.repository.MovementRepository;
import com.java.pokemon.springboot.repository.PokemonRepository;

import java.util.Optional;

@SpringBootApplication
@EntityScan(basePackages = "com.java.pokemon.springboot")
public class SpringBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBotApplication.class, args);
    }

    // Inyecta los repositorios necesarios
    private final PokemonRepository pokemonRepository;
    private final MovementRepository movementRepository;
    private final PokemonPersonalRepository pokemonPersonalRepository;

    public SpringBotApplication(PokemonRepository pokemonRepository, MovementRepository movementRepository, PokemonPersonalRepository pokemonPersonalRepository) {
        this.pokemonRepository = pokemonRepository;
        this.movementRepository = movementRepository;
        this.pokemonPersonalRepository = pokemonPersonalRepository;

        // Crear Movimientos de ejemplo
        MovementModel impactrueno = new MovementModel("Impactrueno", 50, "Eléctrico");
        MovementModel placaje = new MovementModel("Placaje", 40, "Normal");

        // Guardar los Movimientos en la base de datos
        movementRepository.save(impactrueno);
        movementRepository.save(placaje);

        // Crear Pokémon de ejemplo y asignarles los Movimientos
        PokemonModel pikachu = new PokemonModel("Pikachu", "Eléctrico");
        pikachu.addMovement(impactrueno);
        pokemonRepository.save(pikachu);

        PokemonModel bulbasaur = new PokemonModel("Bulbasaur", "Planta");
        bulbasaur.addMovement(placaje);
        pokemonRepository.save(bulbasaur);

        // Buscar a Pikachu por nombre y asignarlo a Pikachu Personal
        Optional<PokemonModel> pokemonBasePikachuOptional = pokemonRepository.findByNombre("Pikachu");
        if (pokemonBasePikachuOptional.isPresent()) {
            PokemonModel pokemonBasePikachu = pokemonBasePikachuOptional.get();
            PokemonPersonal pikachuPersonal = new PokemonPersonal("Pikachu Personal");
            pikachuPersonal.setPokemonBase(pokemonBasePikachu);
            pikachuPersonal.addMovement(impactrueno);
            pokemonPersonalRepository.save(pikachuPersonal);
        }

        // Buscar a Bulbasaur por nombre y asignarlo a Bulbasaur Personal
        Optional<PokemonModel> pokemonBaseBulbasaurOptional = pokemonRepository.findByNombre("Bulbasaur");
        if (pokemonBaseBulbasaurOptional.isPresent()) {
            PokemonModel pokemonBaseBulbasaur = pokemonBaseBulbasaurOptional.get();
            PokemonPersonal bulbasaurPersonal = new PokemonPersonal("Bulbasaur Personal");
            bulbasaurPersonal.setPokemonBase(pokemonBaseBulbasaur);
            bulbasaurPersonal.addMovement(placaje);
            pokemonPersonalRepository.save(bulbasaurPersonal);
        }
    }
	
	

}
