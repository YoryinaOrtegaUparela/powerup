package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.UsuarioRequestDto;
import com.pragma.powerup.application.dto.response.UsuarioResponseDto;
import com.pragma.powerup.domain.model.Rol;

public interface UsuarioHandler {
    UsuarioResponseDto guardarUsuario(UsuarioRequestDto usuarioRequestDto);


    UsuarioResponseDto recuperarUsuarioPorId(Long idUsuario);
}
