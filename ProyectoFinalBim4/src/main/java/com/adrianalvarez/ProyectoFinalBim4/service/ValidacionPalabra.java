package com.adrianalvarez.ProyectoFinalBim4.service;

import com.adrianalvarez.ProyectoFinalBim4.model.Palabra;
import com.adrianalvarez.ProyectoFinalBim4.repository.PalabraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacionPalabra {

    private static PalabraRepository palabraRepository;

    @Autowired
    public ValidacionPalabra(PalabraRepository palabraRepository){
        ValidacionPalabra.palabraRepository = palabraRepository;
    }

    public String validarPalabra(Palabra palabra){

        if (palabraRepository.existsByPalabra(palabra.getPalabra())){
            return "Esta palabra ya existe! Crea otra palabra ;D";
        }

        return null;
    }
}
