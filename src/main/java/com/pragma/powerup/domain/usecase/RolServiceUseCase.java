package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.RolServicePort;
import com.pragma.powerup.domain.spi.RolPersistencePort;
import com.pragma.powerup.infrastructure.exception.NoValidRolException;

public class RolServiceUseCase implements RolServicePort {

    private RolPersistencePort rolPersistencePort;

    public RolServiceUseCase(RolPersistencePort rolPersistencePort) {
        this.rolPersistencePort = rolPersistencePort;
    }

    @Override
    public boolean validateExistRol(Long id)throws NoValidRolException {
        return rolPersistencePort.validateExistRol(id);
    }
}