package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.exception.NoValidRolException;
import com.pragma.powerup.domain.model.Rol;
import com.pragma.powerup.domain.model.Usuario;

public interface RolServicePort {

    public boolean validateExistRol(Long id)throws NoValidRolException;

    public Rol recuperarRolPorIdRol(Long idRol);

}
