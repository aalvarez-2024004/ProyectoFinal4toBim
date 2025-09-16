package com.adrianalvarez.ProyectoFinalBim4.controller;

import com.adrianalvarez.ProyectoFinalBim4.model.Usuario;
import com.adrianalvarez.ProyectoFinalBim4.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
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

    //Obtener toidos los usuarios
    @GetMapping
    public List<Usuario> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    //Buscar un usuario segund su Id
    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Integer id){
        return usuarioService.getUsuarioById(id);
    }

    //Crear a un nuevo usuario
    @PostMapping
    public ResponseEntity<Object> createUsuario(@Valid @RequestBody Usuario usuario){
        try{
            Usuario createdUsuario = usuarioService.saveUsuario(usuario);
            return new ResponseEntity<>(createdUsuario, HttpStatus.CREATED);
        } catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Actualizar un usuario
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUsuario(@PathVariable Integer id, @Valid @RequestBody Usuario usuario) {
        try{
            Usuario updatedUsuario = usuarioService.updateUsuario(id, usuario);
            if (updatedUsuario == null) {
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
            }

            return ResponseEntity.ok(updatedUsuario);

        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Integer id){
        usuarioService.deleteUsuario(id);
    }

}
