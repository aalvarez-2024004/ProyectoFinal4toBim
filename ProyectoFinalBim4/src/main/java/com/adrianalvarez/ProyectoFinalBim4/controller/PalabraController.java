package com.adrianalvarez.ProyectoFinalBim4.controller;


import com.adrianalvarez.ProyectoFinalBim4.model.Palabra;
import com.adrianalvarez.ProyectoFinalBim4.service.PalabraService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/palabras")
public class PalabraController {

    private final PalabraService palabraService;

    public PalabraController(PalabraService palabraService) {
        this.palabraService = palabraService;
    }

    //OBtener las palabras
    @GetMapping
    public List<Palabra> getAllPalabras(){
        return palabraService.getAllPalabras();
    }

    //BUSCAR UNA PALABRA POR ID
    @GetMapping("/{id}")
    public Palabra PalabraById(@PathVariable Integer id){
        return palabraService.getPalabraById(id);
    }

    //Crear una palabra
    @PostMapping
    public ResponseEntity<Object> createPalabra(@Valid @RequestBody Palabra palabra){
        try {
            Palabra createdPalabra = palabraService.savePalabra(palabra);
            return new ResponseEntity<>(createdPalabra, HttpStatus.CREATED);
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //Actualizar una palabra
    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePalabra(@PathVariable Integer id, @Valid @RequestBody Palabra palabra){
        try {
            Palabra updatedPalabra = palabraService.updatePalabra(id, palabra);

            if (updatedPalabra == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La palabra no se encontro");
            }

            return ResponseEntity.ok(updatedPalabra);

        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //Eliminar una palabra
    @DeleteMapping("/{id}")
    public void deletePalabra(@PathVariable Integer id){
        palabraService.deletePalabra(id);
    }

    // Manejo de validaciones
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(errors);
    }
}
