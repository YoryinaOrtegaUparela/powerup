package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.Rol;
import com.pragma.powerup.domain.spi.RolPersistencePort;
import com.pragma.powerup.domain.exception.RolNoValidoException;
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
    public boolean validarSiExisteRol(Long id) throws RolNoValidoException {
        Optional<RolEntity> rol = rolRepository.findById(id);
        if (rol.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Rol recuperarRolPorIdRol(Long idRol) {

        Optional<RolEntity> rol = rolRepository.findById(idRol);
        if (!rol.isPresent()) {
            throw new RolNoValidoException("El IdRol " + idRol + " no existe.");
        }
        return RolEntityMapper.rolEntityToRol(rol.get());
    }

    @Override
    public RolEntity recuperarRolPorCodigo(String codigo) {
        Optional<RolEntity> rolEntity = rolRepository.buscarRolPorCodigo(codigo);
        if (!rolEntity.isPresent()) {
            throw new RolNoValidoException("El Codigo del  " + codigo + " no existe.");
        }
        return rolEntity.get();
    }
}
