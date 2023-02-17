package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.UsuarioRequestDto;
import com.pragma.powerup.application.handler.UsuarioHandler;
import com.pragma.powerup.application.mapper.UsuarioRequestMapper;
import com.pragma.powerup.domain.api.RolServicePort;
import com.pragma.powerup.domain.api.SecurityPasswordServicePort;
import com.pragma.powerup.domain.api.UsuarioServicePort;
import com.pragma.powerup.domain.model.Usuario;
import com.pragma.powerup.infrastructure.exception.NoValidRolException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioHandlerImpl implements UsuarioHandler {

    private UsuarioServicePort usuarioServicePort;
    private SecurityPasswordServicePort securityPasswordServicePort;
    private RolServicePort rolServicePort;
    private UsuarioRequestMapper usuarioRequestMapper;

    public UsuarioHandlerImpl(UsuarioServicePort usuarioServicePort, SecurityPasswordServicePort securityPasswordServicePort, RolServicePort rolServicePort, UsuarioRequestMapper usuarioRequestMapper) {
        this.usuarioServicePort = usuarioServicePort;
        this.securityPasswordServicePort = securityPasswordServicePort;
        this.rolServicePort = rolServicePort;
        this.usuarioRequestMapper = usuarioRequestMapper;
    }

    @Override
    public void guardarUsuario(UsuarioRequestDto usuarioRequestDto) {
        rolServicePort.validateExistRol(usuarioRequestDto.getIdRol());

        encriptar(usuarioRequestDto);

        Usuario usuario = usuarioRequestMapper.usuarioRequestDtoToUsuario(usuarioRequestDto);
        usuarioServicePort.crearUsuario(usuario);
    }


    private UsuarioRequestDto encriptar(UsuarioRequestDto usuarioRequestDto) {
        String claveEncriptada = securityPasswordServicePort.encriptarContrasena(usuarioRequestDto.getClave());
        usuarioRequestDto.setClave(claveEncriptada);
        return usuarioRequestDto;
    }
}

