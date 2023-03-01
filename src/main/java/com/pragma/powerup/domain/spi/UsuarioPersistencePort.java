package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.Usuario;
/*
Contrato que gestiona la persistencia de los usuarios
 */
public interface UsuarioPersistencePort {

    public Usuario guardarUsuario(Usuario usuarioNuevo);

    public Usuario recuperarUsuarioPorId(Long idUsuario);

    Usuario findBycorreo(String correo);

}
