package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.Usuario;
import com.pragma.powerup.domain.spi.UsuarioPersistencePort;
import com.pragma.powerup.infrastructure.exception.UserNotFoundException;
import com.pragma.powerup.infrastructure.out.jpa.entity.RolEntity;
import com.pragma.powerup.infrastructure.out.jpa.entity.UsuarioEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.UsuarioEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.RolRepository;
import com.pragma.powerup.infrastructure.out.jpa.repository.UsuarioRepository;

import java.util.Optional;

public class UsuarioPersistenceAdapter implements UsuarioPersistencePort {

    private UsuarioEntityMapper usuarioEntityMapper;
    private UsuarioRepository usuarioRepository;

    public UsuarioPersistenceAdapter(UsuarioEntityMapper usuarioEntityMapper, UsuarioRepository usuarioRepository) {
        this.usuarioEntityMapper = usuarioEntityMapper;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario guardarUsuario(Usuario usuarioNuevo) {

        UsuarioEntity usuarioConvertido = usuarioEntityMapper.usuarioToUsuarioEntity(usuarioNuevo);

        UsuarioEntity usuarioCreado = usuarioRepository.save(usuarioConvertido);
        usuarioNuevo.setId(usuarioCreado.getId());

        return usuarioNuevo;

    }

    @Override
    public Usuario recuperarUsuarioPorId(Long idUsuario) {
        Optional<UsuarioEntity> usuarioPorId = usuarioRepository.findById(idUsuario);
        if (!usuarioPorId.isPresent()) {
            throw new UserNotFoundException("El usuario para el id " + idUsuario + " no se encuentra registrado");
        }

        return usuarioEntityMapper.usuarioEntityToUsuario(usuarioPorId.get());


    }


}
