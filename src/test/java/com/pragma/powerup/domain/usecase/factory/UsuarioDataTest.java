package com.pragma.powerup.domain.usecase.factory;

import com.pragma.powerup.domain.model.Usuario;

public class UsuarioDataTest {

    public static Usuario getUsuarioNuevo(){

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setClave("2589");
        nuevoUsuario.setNombre("Jairo");
        nuevoUsuario.setApellido("Beltran");
        nuevoUsuario.setDocumentoIdentidad("123456");
        nuevoUsuario.setCelular("3003371724");
        nuevoUsuario.setCorreo("ja@email.com");
        nuevoUsuario.setIdRol(1L);
        return nuevoUsuario;
    }

    public static Usuario getUsuarioEmailIncorrecto(){

        Usuario nuevoUsuario = getUsuarioNuevo();
        nuevoUsuario.setCorreo("malo");
        return nuevoUsuario;
    }

    public static Usuario getUsuarioDatoFaltante(){

        Usuario nuevoUsuario = getUsuarioNuevo();
        nuevoUsuario.setCelular(null);
        return nuevoUsuario;
    }
    public static Usuario getUsuarioDocumentoIdentidadNoNumerico(){

        Usuario nuevoUsuario = getUsuarioNuevo();
        nuevoUsuario.setDocumentoIdentidad("123asd");
        return nuevoUsuario;
    }

    public static Usuario getUsuarioTelefonoMaximoCaracteres(){

        Usuario nuevoUsuario = getUsuarioNuevo();
        nuevoUsuario.setCelular("12345678912345");
        return nuevoUsuario;
    }
}
