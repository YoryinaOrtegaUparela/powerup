package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.api.RolServicePort;
import com.pragma.powerup.domain.model.Rol;
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

    private RolServicePort rolServicePort;

    public UsuarioPersistenceAdapter(UsuarioEntityMapper usuarioEntityMapper, UsuarioRepository usuarioRepository, RolServicePort rolServicePort) {
        this.usuarioEntityMapper = usuarioEntityMapper;
        this.usuarioRepository = usuarioRepository;
        this.rolServicePort = rolServicePort;
    }

    @Override
    public Usuario guardarUsuario(Usuario usuarioNuevo) {

        //Consultamos Id de ROl para guardarcorrectamente la relacion
        Long idRol = rolServicePort.recuperaridRolPorcodigo(usuarioNuevo.getRol().getCodigo());
        usuarioNuevo.setIdRol(idRol);

        UsuarioEntity usuarioConvertido = usuarioEntityMapper.usuarioToUsuarioEntity(usuarioNuevo);

        UsuarioEntity usuarioCreadoEntity = usuarioRepository.save(usuarioConvertido);

        //Seteo Id del usuario creado para devolver la respuesta con el id De DB
        usuarioNuevo.setId(usuarioCreadoEntity.getId());
        return usuarioNuevo;

    }

    @Override
    public Usuario recuperarUsuarioPorId(Long idUsuario) {
        Optional<UsuarioEntity> usuarioPorId = usuarioRepository.findById(idUsuario);
        if (!usuarioPorId.isPresent()) {
            throw new UserNotFoundException("El usuario para el id " + idUsuario + " no se encuentra registrado");
        }
        Usuario usuario = usuarioEntityMapper.usuarioEntityToUsuario(usuarioPorId.get());
        Rol rol = rolServicePort.recuperarRolPorIdRol(usuario.getIdRol());
        usuario.setRol(rol);

        return usuario;


    }

    @Override
    public Usuario findBycorreo(String correo) {
        Optional<UsuarioEntity> usuarioPorCorreo = usuarioRepository.findBycorreo(correo);
        if (!usuarioPorCorreo.isPresent()) {
            throw new UserNotFoundException("El usuario para el correo: " + correo + " no se encuentra registrado");
        }
        Usuario usuario = usuarioEntityMapper.usuarioEntityToUsuario(usuarioPorCorreo.get());
        Rol rol = rolServicePort.recuperarRolPorIdRol(usuario.getIdRol());
        usuario.setRol(rol);
        return usuario;

    }


}
