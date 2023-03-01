package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.exception.RolNoValidoException;
import com.pragma.powerup.domain.model.Rol;
import com.pragma.powerup.infrastructure.out.jpa.entity.RolEntity;

public interface RolPersistencePort {

    public boolean validarSiExisteRol(Long id) throws RolNoValidoException;

    public Rol recuperarRolPorIdRol(Long idRol);

    RolEntity recuperarRolPorCodigo(String codigo);
}
