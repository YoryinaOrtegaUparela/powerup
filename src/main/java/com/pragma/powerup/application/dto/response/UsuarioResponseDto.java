package com.pragma.powerup.application.dto.response;

public class UsuarioResponseDto {

    private String nombre;
    private Long id;


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
