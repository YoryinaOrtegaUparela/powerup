package com.pragma.powerup.domain.model;

import com.pragma.powerup.domain.exception.RolNoValidoException;

public enum Rol {
    ADMINISTRADOR("rol administrador", "ADMIN"),
    PROPIETARIO("dueño del restaurante", "PROP"),
    EMPLEADO("trabajador del restaurante", "EMPLE"),
    CLIENTE("cliente", "CLIENT");

    private String descripcion;
    private String codigo;

    private Rol(String descripcion) {
        this.descripcion = descripcion;
    }

    Rol(String descripcion, String codigo) {
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public String getCodigo() {
        return codigo;
    }


    public static Rol getRolbyCodigo(String codigo) {
        switch (codigo) {
            case "ADMIN": {
                return ADMINISTRADOR;
            }
            case "PROP": {
                return PROPIETARIO;
            }
            case "EMPLE": {
                return EMPLEADO;
            }
            case "CLIENT": {
                return CLIENTE;
            }
            default: {
                throw new RolNoValidoException("No existe un rol para el codigo:" + codigo);
            }
        }
    }
}
