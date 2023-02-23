package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.RolServicePort;
import com.pragma.powerup.domain.api.UsuarioServicePort;
import com.pragma.powerup.domain.exception.NoValidRolException;
import com.pragma.powerup.domain.helper.UsuarioDataValidator;
import com.pragma.powerup.domain.model.Rol;
import com.pragma.powerup.domain.model.Usuario;
import com.pragma.powerup.domain.spi.SecurityPasswordPort;
import com.pragma.powerup.domain.spi.UsuarioPersistencePort;

/*
Casos de uso relacionados al usuario
 */
public class UsuarioServiceUseCase implements UsuarioServicePort {

    private UsuarioPersistencePort usuarioPersistencePort;

    private SecurityPasswordPort securityPasswordPort;

    private RolServicePort rolServicePort;

    public UsuarioServiceUseCase(UsuarioPersistencePort usuarioPersistencePort, SecurityPasswordPort securityPasswordPort, RolServicePort rolServicePort) {
        this.usuarioPersistencePort = usuarioPersistencePort;
        this.securityPasswordPort = securityPasswordPort;
        this.rolServicePort = rolServicePort;
    }

    @Override
    public Usuario crearUsuario(Usuario nuevoUsuario) {

        //validar que los datos de un Usuario estan correctos
        UsuarioDataValidator.validarUsuario(nuevoUsuario);
        //Encriptar la contraseña
        encriptarContrasenaUsuario(nuevoUsuario);
        //Persistir usuario
        Usuario usuario = usuarioPersistencePort.guardarUsuario(nuevoUsuario);


        return usuario;
    }

    @Override
    public Usuario recuperarUsuarioPorId(Long idUsuario) {
        Usuario usuario = usuarioPersistencePort.recuperarUsuarioPorId(idUsuario);
        return usuario;
    }


    private void encriptarContrasenaUsuario(Usuario usuario) {
        usuario.setClave(securityPasswordPort.encriptarContrasena(usuario.getClave()));
    }


}
