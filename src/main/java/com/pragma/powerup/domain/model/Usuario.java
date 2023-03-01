package com.pragma.powerup.domain.model;

public class Usuario {

    private Long id;
    private String nombre;
    private String apellido;
    private String celular;
    private String documentoIdentidad;
    private String correo;
    private String clave;
    private Long idRol;
    private Rol rol;

    public Usuario(Long id, String nombre, String apellido, String celular, String documentoIdentidad, String correo, String clave, Long idRol, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.documentoIdentidad = documentoIdentidad;
        this.correo = correo;
        this.clave = clave;
        this.idRol = idRol;
        this.rol = rol;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getCodigoRol(){
        return this.getRol().getCodigo();
    }
}
