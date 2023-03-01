package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.RolServicePort;
import com.pragma.powerup.domain.api.UsuarioServicePort;
import com.pragma.powerup.domain.helper.ValidadorDataDeUsuario;
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
    public Usuario crearUsuario(Usuario usuario) {

        //validar que los datos de un Usuario estan correctos
        ValidadorDataDeUsuario.validarUsuario(usuario);
        //Encriptar la contraseña
        encriptarContrasenaUsuario(usuario);
        //Persistir usuario
        Usuario usuarioCreado = usuarioPersistencePort.guardarUsuario(usuario);

        return usuarioCreado;
    }

    @Override
    public Usuario recuperarUsuarioPorId(Long idUsuario) {
        Usuario usuario = usuarioPersistencePort.recuperarUsuarioPorId(idUsuario);
        return usuario;
    }

    @Override
    public Usuario validarUsuarioPorCorreo(String correo) {
        Usuario usuario = usuarioPersistencePort.findBycorreo(correo);
        return usuario;
    }

    private void encriptarContrasenaUsuario(Usuario usuario) {
        usuario.setClave(securityPasswordPort.encriptarContrasena(usuario.getClave()));
    }
}
