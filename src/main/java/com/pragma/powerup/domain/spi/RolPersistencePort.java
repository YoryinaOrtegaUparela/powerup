package com.pragma.powerup.domain.spi;

import com.pragma.powerup.infrastructure.exception.NoValidRolException;

public interface RolPersistencePort {

    public boolean validateExistRol(Long id) throws NoValidRolException;
}
