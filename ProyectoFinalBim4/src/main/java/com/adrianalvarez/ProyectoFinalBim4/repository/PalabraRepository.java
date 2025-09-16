package com.adrianalvarez.ProyectoFinalBim4.repository;


import com.adrianalvarez.ProyectoFinalBim4.model.Palabra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalabraRepository extends JpaRepository<Palabra, Integer> {

    boolean existsByPalabra(String Palabra);
}
