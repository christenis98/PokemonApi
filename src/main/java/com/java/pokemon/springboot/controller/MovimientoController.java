package com.java.pokemon.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.java.pokemon.springboot.models.MovementModel;
import com.java.pokemon.springboot.repository.MovementRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movimiento")
public class MovimientoController {
    @Autowired
    private MovementRepository movimientoRepository;

    // Endpoint para crear un nuevo movimiento
    @PostMapping("/")
    public MovementModel crearMovimiento(@RequestBody MovementModel movimiento) {
        return movimientoRepository.save(movimiento);
    }

    // Endpoint para obtener todos los movimientos
    @GetMapping("/")
    public List<MovementModel> obtenerTodosLosMovimientos() {
        return movimientoRepository.findAll();
    }

    // Endpoint para obtener un movimiento por ID
    @GetMapping("/{id}")
    public Optional<MovementModel> obtenerMovimientoPorId(@PathVariable Long id) {
        return movimientoRepository.findById(id);
    }

    // Endpoint para actualizar un movimiento
    @PutMapping("/{id}")
    public MovementModel actualizarMovimiento(@PathVariable Long id, @RequestBody MovementModel movimientoActualizado) {
        return movimientoRepository.findById(id)
            .map(movimiento -> {
                movimiento.setNombre(movimientoActualizado.getNombre());
                movimiento.setPoder(movimientoActualizado.getPoder());
                // Actualiza otros atributos según sea necesario
                return movimientoRepository.save(movimiento);
            })
            .orElseThrow(null);
    }

    // Endpoint para eliminar un movimiento por ID
    @DeleteMapping("/{id}")
    public void eliminarMovimiento(@PathVariable Long id) {
        movimientoRepository.deleteById(id);
    }
}
