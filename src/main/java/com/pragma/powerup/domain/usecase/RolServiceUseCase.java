package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.RolServicePort;
import com.pragma.powerup.domain.model.Rol;
import com.pragma.powerup.domain.spi.RolPersistencePort;
import com.pragma.powerup.domain.exception.RolNoValidoException;

public class RolServiceUseCase implements RolServicePort {

    private RolPersistencePort rolPersistencePort;

    public RolServiceUseCase(RolPersistencePort rolPersistencePort) {
        this.rolPersistencePort = rolPersistencePort;
    }

    @Override
    public boolean validarSiExistRol(Long id) throws RolNoValidoException {
        return rolPersistencePort.validarSiExisteRol(id);
    }

    @Override
    public Rol recuperarRolPorIdRol(Long idRol) {
        return rolPersistencePort.recuperarRolPorIdRol(idRol);
    }

    @Override
    public Long recuperarIdRolPorcodigo(String codigo) {
        return rolPersistencePort.recuperarRolPorCodigo(codigo).getId();
    }
}
