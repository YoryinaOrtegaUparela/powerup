package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.UsuarioRequestDto;
import com.pragma.powerup.application.dto.response.UsuarioResponseDto;
import com.pragma.powerup.application.handler.UsuarioHandler;
import com.pragma.powerup.application.mapper.UsuarioRequestMapper;
import com.pragma.powerup.application.mapper.UsuarioResponseMapper;
import com.pragma.powerup.domain.api.UsuarioServicePort;
import com.pragma.powerup.domain.model.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioHandlerImpl implements UsuarioHandler {

    private UsuarioServicePort usuarioServicePort;
    private UsuarioRequestMapper usuarioRequestMapper;
    private UsuarioResponseMapper usuarioResponseMapper;

    public UsuarioHandlerImpl(UsuarioServicePort usuarioServicePort, UsuarioRequestMapper usuarioRequestMapper, UsuarioResponseMapper usuarioResponseMapper) {
        this.usuarioServicePort = usuarioServicePort;
        this.usuarioRequestMapper = usuarioRequestMapper;
        this.usuarioResponseMapper = usuarioResponseMapper;
    }

    @Override
    public UsuarioResponseDto guardarUsuario(UsuarioRequestDto usuarioRequestDto) {
        //Mapeo
        Usuario usuario = usuarioRequestMapper.usuarioRequestDtoToUsuario(usuarioRequestDto);
        //Mando al Dominio a crear con las validaciones necesarias
        Usuario usuarioCreado = usuarioServicePort.crearUsuario(usuario);
        UsuarioResponseDto usuarioResponseDto = usuarioResponseMapper.usuarioToUsuarioResponseDto(usuarioCreado);
        return usuarioResponseDto;
    }


}

