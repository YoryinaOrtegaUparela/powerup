package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.Rol;
import com.pragma.powerup.domain.spi.RolPersistencePort;
import com.pragma.powerup.domain.exception.NoValidRolException;
import com.pragma.powerup.infrastructure.out.jpa.entity.RolEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.RolEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.RolRepository;

import java.util.Optional;

public class RolPersistenceAdapter implements RolPersistencePort {

    private RolRepository rolRepository;


    public RolPersistenceAdapter(RolRepository rolRepository) {
        this.rolRepository = rolRepository;

    }

    @Override
    public boolean validateExistRol(Long id) throws NoValidRolException {
        Optional<RolEntity> rol = rolRepository.findById(id);
        if (rol.isPresent()) {
            return true;
        }else{
            return false;
        }

    }

    @Override
    public Rol recuperarRolPorIdRol(Long idRol) {

        Optional<RolEntity> rol = rolRepository.findById(idRol);
        if (!rol.isPresent()) {
            throw new NoValidRolException("El IdRol " + idRol + " no existe.");
        }
        return RolEntityMapper.rolEntityToRol(rol.get());


    }

}
