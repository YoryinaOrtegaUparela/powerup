package com.pragma.powerup.infrastructure.out.jpa.mapper;

import com.pragma.powerup.domain.model.Rol;
import com.pragma.powerup.infrastructure.out.jpa.entity.RolEntity;


public class RolEntityMapper {

    /*
    Convierte un usuario a usuario entidad
     */
    public static Rol rolEntityToRol(RolEntity rol) {
        Rol rolbyCodigo = Rol.getRolbyCodigo(rol.getCodigo());
        return rolbyCodigo;
    }


}
