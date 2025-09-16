package com.adrianalvarez.ProyectoFinalBim4.repository;

import com.adrianalvarez.ProyectoFinalBim4.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    boolean existsByUsuario(String usuario);
}
