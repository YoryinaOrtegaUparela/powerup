package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.UsuarioRequestDto;
import com.pragma.powerup.application.dto.response.UsuarioResponseDto;

public interface UsuarioHandler {
    UsuarioResponseDto crearUsuario(UsuarioRequestDto usuarioRequestDto);
    UsuarioResponseDto recuperarUsuarioPorId(Long idUsuario);
    UsuarioResponseDto validarUsuarioPorCorreo(String correo);
}
