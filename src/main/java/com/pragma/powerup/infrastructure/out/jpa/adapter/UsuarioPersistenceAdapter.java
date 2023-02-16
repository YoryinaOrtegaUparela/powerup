package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.Usuario;
import com.pragma.powerup.domain.spi.UsuarioPersistencePort;
import com.pragma.powerup.infrastructure.out.jpa.entity.RolEntity;
import com.pragma.powerup.infrastructure.out.jpa.entity.UsuarioEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.UsuarioEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.RolRepository;
import com.pragma.powerup.infrastructure.out.jpa.repository.UsuarioRepository;

public class UsuarioPersistenceAdapter implements UsuarioPersistencePort {

    private UsuarioEntityMapper usuarioEntityMapper;
    private UsuarioRepository usuarioRepository;

    public UsuarioPersistenceAdapter(UsuarioEntityMapper usuarioEntityMapper, UsuarioRepository usuarioRepository) {
        this.usuarioEntityMapper = usuarioEntityMapper;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void guardarUsuario(Usuario usuarioNuevo) {
       UsuarioEntity usuarioConvertido = usuarioEntityMapper.usuarioToUsuarioEntity(usuarioNuevo);
       usuarioRepository.save(usuarioConvertido);
    }




}
