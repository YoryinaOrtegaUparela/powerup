package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.Usuario;

/*
Contrato que define la creación de usuarios
 */
public interface UsuarioServicePort {

    public Usuario crearUsuario(Usuario nuevoUsuario);

    public Usuario recuperarUsuarioPorId(Long idUsuario);

}
