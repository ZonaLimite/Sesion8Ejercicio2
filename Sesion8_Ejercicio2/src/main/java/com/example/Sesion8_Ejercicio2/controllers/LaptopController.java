package com.example.Sesion8_Ejercicio2.controllers;

import com.example.Sesion8_Ejercicio2.entities.Laptop;
import com.example.Sesion8_Ejercicio2.repositories.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);
    private final LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptops")
    public ResponseEntity<List<Laptop>> findAll() {
        return ResponseEntity.ok().body(laptopRepository.findAll());
    }

    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id) {
        Optional optionalLaptop = laptopRepository.findById(id);
        return optionalLaptop.isPresent() ?
                ResponseEntity.ok((Laptop) optionalLaptop.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop) {
       return ResponseEntity.created(null).body(laptopRepository.save(laptop));
    }

    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
        if (laptop.getId() == null) {
            log.warn("Triying to update a laptop without id");
            return ResponseEntity.badRequest().build();
        }
        Long id = laptop.getId();
        if (!laptopRepository.existsById(id)) {
            log.warn("No existe el Id proporcionado");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(laptopRepository.save(laptop));

    }
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id) {
        Optional optionalLaptop = laptopRepository.findById(id);
        if(optionalLaptop.isPresent()){
            laptopRepository.delete((Laptop) optionalLaptop.get());
            log.info("Borrado laptop con id : " + id);
            return ResponseEntity.noContent().build();
        }else{
            log.warn("No se ha encontrado el registro para borrar (id="+id+")");
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        laptopRepository.deleteAll();
        log.info("Se borraron todos los registros");
        return ResponseEntity.ok().build();
    }
}
