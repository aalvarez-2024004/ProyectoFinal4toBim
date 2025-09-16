package com.adrianalvarez.ProyectoFinalBim4.service;

import com.adrianalvarez.ProyectoFinalBim4.model.Palabra;

import java.util.List;

public interface PalabraService {
    List<Palabra> getAllPalabras();
    Palabra getPalabraById(Integer id);
    Palabra savePalabra(Palabra palabra);
    Palabra updatePalabra(Integer id, Palabra palabra);
    void deletePalabra(Integer id);
}
