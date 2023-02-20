package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.exception.NoValidRolException;

/*
Contrato que define la creación de roles
 */
public interface RolServicePort {

    public boolean validateExistRol(Long id)throws NoValidRolException;
}
