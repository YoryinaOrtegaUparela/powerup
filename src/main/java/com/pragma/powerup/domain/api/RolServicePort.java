package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.exception.NoValidRolException;
import com.pragma.powerup.domain.model.Rol;
import com.pragma.powerup.domain.model.Usuario;

/*
Contrato que define la creación de roles
 */
public interface RolServicePort {

    public boolean validateExistRol(Long id)throws NoValidRolException;

    public Rol recuperarRolPorIdRol(Long idRol);

    public Long recuperaridRolPorcodigo(String codigo);

}
