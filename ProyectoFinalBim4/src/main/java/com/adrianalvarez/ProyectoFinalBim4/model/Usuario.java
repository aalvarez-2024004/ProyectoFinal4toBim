package com.adrianalvarez.ProyectoFinalBim4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name ="Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_usuario")
    private Integer codigoUsuario;

    @NotBlank(message = "DEBES DE AGREGAR UN NOMBRE DE USUARIO!")
    @Size(min = 4, max = 20, message = "El nombre de usuario debe tener minimo 4 caracteres")
    @Column(name = "usuario")
    private String usuario;

    @NotBlank(message = "DEBES DE AGREGAR UNA CONTRASENA PARA EL USUARIO!")
    @Size(min = 5, message = "La contraseña debe tener al menos 5 caracteres")
    @Column(name = "contrasena")
    private String contrasena;

    //Getters y Setters


    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
