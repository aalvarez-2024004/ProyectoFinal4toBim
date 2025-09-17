package com.adrianalvarez.ProyectoFinalBim4.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name ="Palabras")
public class Palabra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="codigo_palabra")
    private Integer codigoPalabra;

    @NotBlank(message = "DEBES DE AGREGAR UNA PALABRA!")
    @Size(min = 8, message = "La palabra debe tener minimo 8 caracteres")
    @Column(name = "palabra")
    private String palabra;

    @NotBlank(message = "La pista 1 es obligatoria")
    @Size(max = 50, message = "La pista 1 no puede pasarse de los 50 caracteres")
    @Column(name = "pista1")
    private String pista1;

    @NotBlank(message = "La pista 2 es obligatoria")
    @Size(max = 50, message = "La pista 2 no puede pasarse de los 50 caracteres")
    @Column(name = "pista2")
    private String pista2;

    @NotBlank(message = "La pista 3 es obligatoria")
    @Size(max = 50, message = "La pista 3 no puede pasarse de los 50 caracteres")
    @Column(name = "pista3")
    private String pista3;

    //Gtters y setters

    public Integer getCodigoPalabra() {
        return codigoPalabra;
    }

    public void setCodigoPalabra(Integer codigoPalabra) {
        this.codigoPalabra = codigoPalabra;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getPista1() {
        return pista1;
    }

    public void setPista1(String pista1) {
        this.pista1 = pista1;
    }

    public String getPista2() {
        return pista2;
    }

    public void setPista2(String pista2) {
        this.pista2 = pista2;
    }

    public String getPista3() {
        return pista3;
    }

    public void setPista3(String pista3) {
        this.pista3 = pista3;
    }
}
