package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.Usuario;

/*
Contrato que define la creación de usuarios
 */
public interface UsuarioServicePort {

    public Usuario crearUsuario(Usuario usuario);

    public Usuario recuperarUsuarioPorId(Long idUsuario);

    Usuario validarUsuarioPorCorreo(String correo);
}
