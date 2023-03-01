package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.api.RolServicePort;
import com.pragma.powerup.domain.model.Rol;
import com.pragma.powerup.domain.model.Usuario;
import com.pragma.powerup.domain.spi.UsuarioPersistencePort;
import com.pragma.powerup.infrastructure.exception.UserNotFoundException;
import com.pragma.powerup.infrastructure.out.jpa.entity.UsuarioEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.UsuarioEntityMapper;
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
    public Usuario guardarUsuario(Usuario usuario) {

        //Consultamos Id de ROl para guardarcorrectamente la relacion
        Long idRol = rolServicePort.recuperarIdRolPorcodigo(usuario.getRol().getCodigo());
        usuario.setIdRol(idRol);

        UsuarioEntity usuarioEntity = usuarioEntityMapper.convertirUsuarioAUsuarioEntity(usuario);

        UsuarioEntity usuarioCreadoEntity = usuarioRepository.save(usuarioEntity);

        //Seteo Id del usuario creado para devolver la respuesta con el id De DB
        usuario.setId(usuarioCreadoEntity.getId());
        return usuario;

    }

    @Override
    public Usuario recuperarUsuarioPorId(Long idUsuario) {
        Optional<UsuarioEntity> usuarioPorId = usuarioRepository.findById(idUsuario);
        if (!usuarioPorId.isPresent()) {
            throw new UserNotFoundException("El usuario para el id " + idUsuario + " no se encuentra registrado");
        }
        Usuario usuario = usuarioEntityMapper.convertirUsuarioEntityAUsuario(usuarioPorId.get());
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
        Usuario usuario = usuarioEntityMapper.convertirUsuarioEntityAUsuario(usuarioPorCorreo.get());
        Rol rol = rolServicePort.recuperarRolPorIdRol(usuario.getIdRol());
        usuario.setRol(rol);
        return usuario;
    }
}
