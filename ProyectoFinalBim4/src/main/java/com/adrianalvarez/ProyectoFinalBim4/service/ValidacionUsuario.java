package com.adrianalvarez.ProyectoFinalBim4.service;

import com.adrianalvarez.ProyectoFinalBim4.model.Usuario;
import com.adrianalvarez.ProyectoFinalBim4.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacionUsuario {

    private static UsuarioRepository usuarioRepository;

    @Autowired
    public ValidacionUsuario(UsuarioRepository usuarioRepository){
        ValidacionUsuario.usuarioRepository = usuarioRepository;
    }

    public String validarUsuario(Usuario usuario){
        if (usuarioRepository.existsByUsuario(usuario.getUsuario())){
            return "Ya existe un usuario con ese nombre de usuario... Intenta con otro :D";
        }

        return null;
    }
}
