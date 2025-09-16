package com.adrianalvarez.ProyectoFinalBim4.service;

import com.adrianalvarez.ProyectoFinalBim4.model.Palabra;
import com.adrianalvarez.ProyectoFinalBim4.repository.PalabraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PalabraServiceImplements implements PalabraService{

    private final PalabraRepository palabraRepository;
    private final ValidacionPalabra validacionPalabra;

    public PalabraServiceImplements(PalabraRepository palabraRepository, ValidacionPalabra validacionPalabra) {
        this.palabraRepository = palabraRepository;
        this.validacionPalabra = validacionPalabra;
    }

    @Override
    public List<Palabra> getAllPalabras(){
        return palabraRepository.findAll();
    }

    @Override
    public Palabra getPalabraById(Integer id){
        return palabraRepository.findById(id).orElse(null);
    }

    @Override
    public Palabra savePalabra(Palabra palabra) {
        String mensaje = validacionPalabra.validarPalabra(palabra);

        if (mensaje != null){
            throw new IllegalArgumentException(mensaje);
        }
        return palabraRepository.save(palabra);
    }

    @Override
    public Palabra updatePalabra(Integer id, Palabra palabra) {
        Palabra existingPalabra = palabraRepository.findById(id).orElse(null);

        if (existingPalabra != null){
            existingPalabra.setPalabra(palabra.getPalabra());
            existingPalabra.setPista1(palabra.getPista1());
            existingPalabra.setPista2(palabra.getPista2());
            existingPalabra.setPista3(palabra.getPista3());

            String mensaje = validacionPalabra.validarPalabra(existingPalabra);

            if (mensaje != null){
                throw new IllegalArgumentException(mensaje);
            }

            return palabraRepository.save(existingPalabra);
        }
        return null;
    }

    @Override
    public void deletePalabra(Integer id) {
        palabraRepository.deleteById(id);
    }




}
