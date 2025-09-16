package com.adrianalvarez.ProyectoFinalBim4.service;


import com.adrianalvarez.ProyectoFinalBim4.model.Usuario;
import com.adrianalvarez.ProyectoFinalBim4.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImplements implements UsuarioService{

    private final UsuarioRepository usuarioRepository;
    private final ValidacionUsuario validacion;

    public UsuarioServiceImplements(UsuarioRepository usuarioRepository, ValidacionUsuario validacion) {
        this.usuarioRepository = usuarioRepository;
        this.validacion = validacion;
    }

    @Override
    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioById(Integer id){
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario saveUsuario(Usuario usuario){
        String mensaje = validacion.validarUsuario(usuario);

        if (mensaje != null) {
            throw new IllegalArgumentException(mensaje);
        }

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Integer id, Usuario usuario){
        Usuario existingUsuario = usuarioRepository.findById(id).orElse(null);

        if (existingUsuario != null){
            existingUsuario.setUsuario(usuario.getUsuario());
            existingUsuario.setContrasena(usuario.getContrasena());

            String mensaje = validacion.validarUsuario(existingUsuario);

            if (mensaje != null) {
                throw new IllegalArgumentException(mensaje);
            }

            return usuarioRepository.save(existingUsuario);
        }
        return null;
    }

    @Override
    public void deleteUsuario(Integer id){
        usuarioRepository.deleteById(id);
    }




}
