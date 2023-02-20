package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.exception.NoValidRolException;

public interface RolServicePort {

    public boolean validateExistRol(Long id)throws NoValidRolException;
}
