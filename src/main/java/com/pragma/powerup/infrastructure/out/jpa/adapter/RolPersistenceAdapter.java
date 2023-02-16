package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.spi.RolPersistencePort;
import com.pragma.powerup.infrastructure.exception.NoValidRolException;
import com.pragma.powerup.infrastructure.out.jpa.entity.RolEntity;
import com.pragma.powerup.infrastructure.out.jpa.repository.RolRepository;

import java.util.Optional;

public class RolPersistenceAdapter implements RolPersistencePort {

    private RolRepository rolRepository;

    public RolPersistenceAdapter(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public boolean validateExistRol(Long id)throws NoValidRolException {
        Optional<RolEntity> rol = rolRepository.findById(id);
        if (rol.isPresent()) {
            return true;
        }
        throw new NoValidRolException("El IdRol " + id + " no existe.");

    }
}
