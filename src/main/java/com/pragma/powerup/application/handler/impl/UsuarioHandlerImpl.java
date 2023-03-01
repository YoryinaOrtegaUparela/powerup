package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.UsuarioRequestDto;
import com.pragma.powerup.application.dto.response.UsuarioResponseDto;
import com.pragma.powerup.application.handler.UsuarioHandler;
import com.pragma.powerup.application.mapper.UsuarioMapper;
import com.pragma.powerup.domain.api.UsuarioServicePort;
import com.pragma.powerup.domain.model.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioHandlerImpl implements UsuarioHandler {
    private UsuarioServicePort usuarioServicePort;
    private UsuarioMapper usuarioMapper;

    public UsuarioHandlerImpl(UsuarioServicePort usuarioServicePort, UsuarioMapper usuarioMapper) {
        this.usuarioServicePort = usuarioServicePort;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public UsuarioResponseDto crearUsuario(UsuarioRequestDto usuarioRequestDto) {
        Usuario usuario = usuarioMapper.convertirUsuarioRequestDtoAUsuario(usuarioRequestDto);
        Usuario usuarioCreado = usuarioServicePort.crearUsuario(usuario);//Mando al Dominio a crear con las validaciones necesarias

        UsuarioResponseDto usuarioResponseDto = usuarioMapper.convertirUsuarioAUsuarioResponseDto(usuarioCreado);
        return usuarioResponseDto;
    }

    @Override
    public UsuarioResponseDto recuperarUsuarioPorId(Long idUsuario) {
        Usuario usuario = usuarioServicePort.recuperarUsuarioPorId(idUsuario);
       return usuarioMapper.convertirUsuarioAUsuarioResponseDto(usuario);
    }

    @Override
    public UsuarioResponseDto validarUsuarioPorCorreo(String correo) {
        Usuario usuario = usuarioServicePort.validarUsuarioPorCorreo(correo);
        UsuarioResponseDto usuarioResponseDto = usuarioMapper.convertirUsuarioAUsuarioResponseDto(usuario);
        usuarioResponseDto.setCodigoRol(usuario.getCodigoRol());
        return usuarioResponseDto;
    }

}

