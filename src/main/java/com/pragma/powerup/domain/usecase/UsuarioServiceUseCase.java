package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.UsuarioServicePort;
import com.pragma.powerup.domain.model.Usuario;
import com.pragma.powerup.domain.spi.UsuarioPersistencePort;

/*
Casos de uso relacionados al usuario
 */
public class UsuarioServiceUseCase implements UsuarioServicePort {

    private UsuarioPersistencePort usuarioPersistencePort;

    public UsuarioServiceUseCase(UsuarioPersistencePort usuarioPersistencePort){
        this.usuarioPersistencePort = usuarioPersistencePort;
    }
    @Override
    public void crearUsuario(Usuario nuevoUsuario) {
        usuarioPersistencePort.guardarUsuario(nuevoUsuario);
    }
}
