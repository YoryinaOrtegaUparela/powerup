package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.Usuario;
/*
Contrato que gestiona la persistencia de los usuarios
 */
public interface UsuarioPersistencePort {

    public void guardarUsuario(Usuario usuarioNuevo);
}
