package com.pragma.powerup.domain.model;

public enum Rol {
    ADMINISTRADOR("rol administrador", "ADMIN"),
    PROPIETARIO("dueño del restaurante", "PROP"),
    EMPLEADO("trabajador del restaurante","EMPLE"),
    CLIENTE("cliente","CLIENT");

    private String descripcion;
    private String codigo;

    private Rol(String descripcion){
        this.descripcion = descripcion;
    }

    Rol(String descripcion, String codigo) {
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public String getCodigo() {
        return codigo;
    }
}
