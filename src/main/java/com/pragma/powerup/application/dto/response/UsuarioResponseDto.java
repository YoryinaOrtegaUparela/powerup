package com.pragma.powerup.application.dto.response;

import com.pragma.powerup.domain.model.Rol;

public class UsuarioResponseDto {

    private String nombre;

    private Long id;

    private Rol rol;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
