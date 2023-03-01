package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.exception.RolNoValidoException;
import com.pragma.powerup.domain.model.Rol;

/*
Contrato que define la creación de roles
 */
public interface RolServicePort {

    public boolean validarSiExistRol(Long id)throws RolNoValidoException;

    public Rol recuperarRolPorIdRol(Long idRol);

    public Long recuperarIdRolPorcodigo(String codigo);

}
