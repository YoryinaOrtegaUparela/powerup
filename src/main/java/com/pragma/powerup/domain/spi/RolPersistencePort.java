package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.exception.NoValidRolException;
import com.pragma.powerup.domain.model.Rol;
import com.pragma.powerup.domain.model.Usuario;
import com.pragma.powerup.infrastructure.out.jpa.entity.UsuarioEntity;

public interface RolPersistencePort {

    public boolean validateExistRol(Long id) throws NoValidRolException;

    public Rol recuperarRolPorIdRol(Long idRol);

}
