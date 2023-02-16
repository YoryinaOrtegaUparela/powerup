package com.pragma.powerup.infrastructure.out.jpa.entity;

import com.pragma.powerup.domain.model.Rol;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Long id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50)
    private String apellido;

    @Column(length = 13)
    private String celular;

    @Column(length = 50)
    private String documentoIdentidad;

    @Column(length = 50)
    private String correo;

    @Column(length = 60)
    private String clave;

    @Column(nullable = false)
    private Long idRol;

    public UsuarioEntity() {
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

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }
}
