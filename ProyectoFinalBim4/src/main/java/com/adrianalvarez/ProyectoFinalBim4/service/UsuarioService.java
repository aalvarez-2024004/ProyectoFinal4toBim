package com.adrianalvarez.ProyectoFinalBim4.service;

import com.adrianalvarez.ProyectoFinalBim4.model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(Integer id);
    Usuario saveUsuario(Usuario usuario) throws  RuntimeException;
    Usuario updateUsuario(Integer id, Usuario usuario);
    void deleteUsuario(Integer id);
}
