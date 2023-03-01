package com.pragma.powerup.application.dto.response;

import com.pragma.powerup.domain.model.Rol;

public class UsuarioResponseDto {

    private Long id;
    private String nombre;
    private Rol rol;
    private String codigoRol;
    private String correo;
    private String clave;


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
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getCodigoRol() {
        return codigoRol;
    }
    public void setCodigoRol(String codigoRol) {
        this.codigoRol = codigoRol;
    }
}
