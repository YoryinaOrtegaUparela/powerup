package com.pragma.powerup.domain.helper;

import com.pragma.powerup.domain.exception.InformacionUsuarioNoEncontradaFoundException;
import com.pragma.powerup.domain.model.Usuario;
import com.pragma.powerup.domain.exception.EstructuraUsuarioNoValidaException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Realizar validaciones sobre usuarios segun la necesidad
 */
public class ValidadorDataDeUsuario {

    /**
     * Verificar los datos de usuario, en caso de no cumplir las reglas definidas lanzará exception
     *
     * @param usuario
     * @return usuario
     */
    public static Usuario validarUsuario(Usuario usuario) {
        //validar Datos obligatorios
        validarDataObligatoria(usuario);
        //Validar que la estructura de los datos sea la correcta
        validarEstructuraEnData(usuario);

        return usuario;
    }

    /**
     * Verificar que la data cumple con la estructura requerida
     *
     * @param usuario
     */
    private static void validarEstructuraEnData(Usuario usuario) {
        validarCorreo(usuario.getCorreo());
        celularEsValido(usuario.getCelular());
        validarDocumentoIdentidad(usuario.getDocumentoIdentidad());
    }


    /**
     * Validar los datos de Usuario para verificar que está cumpliendo con los datos obligatorios
     *
     * @param usuario
     * @return
     */
    private static void validarDataObligatoria(Usuario usuario) {
        if (isNull(usuario.getNombre())) {
            throw new InformacionUsuarioNoEncontradaFoundException("El atributo nombre es obligatorio");
        } else if (isNull(usuario.getApellido())) {
            throw new InformacionUsuarioNoEncontradaFoundException("El atributo apellido es obligatorio");
        } else if (isNull(usuario.getDocumentoIdentidad())) {
            throw new InformacionUsuarioNoEncontradaFoundException("El atributo documento de Identidad es obligatorio");
        } else if (isNull(usuario.getCelular())) {
            throw new InformacionUsuarioNoEncontradaFoundException("El atributo celular es obligatorio");
        } else if (isNull(usuario.getCorreo())) {
            throw new InformacionUsuarioNoEncontradaFoundException("El atributo correo es obligatorio");
        } else if (isNull(usuario.getClave())) {
            throw new InformacionUsuarioNoEncontradaFoundException("El atributo clave es obligatorio");
        }
    }

    /**
     * Método para validar que la estructura de un correo se encuentra bien definida
     *
     * @param correo
     * @return correo validado correctamente
     */
    private static void validarCorreo(String correo) {
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        //Si no cumple con la expresion no es valido
        if (!mather.find()) {
            throw new EstructuraUsuarioNoValidaException("El formato del correo no es valido");
        }
    }

    /**
     * Validar si un numero de celular es valido para el dominio de la Aplicacion
     *
     * @param celular
     * @return
     */
    private static void celularEsValido(String celular) {
        validarEstructuraCelular(celular);
        validarTamanoCelular(celular);
    }

    /**
     * Método para validar que el telefono celular cuente con máximo 13 caracteres
     *
     * @param celular
     * @return celular validado
     */
    private static void validarTamanoCelular(String celular) {
        if (celular.length() > 13) {
            throw new EstructuraUsuarioNoValidaException("El número de caracteres del atributo celular es mayor a 13");
        }
    }

    /**
     * Método para validar que el atributo celular sea unicamente numerico y pueda contener el símbolo +
     *
     * @param celular
     * @return celular
     */
    private static void validarEstructuraCelular(String celular) {
        Pattern pattern = Pattern
                .compile("^\\+?\\d+$");
        Matcher mather = pattern.matcher(celular);
        if (!mather.find()) {
            throw new EstructuraUsuarioNoValidaException("El atributo celular debe ser numerico y puede iniciar con +");
        }
    }

    /**
     * Método para verificar que el documento de identidad sea solo numerico
     *
     * @param documentoIdentidad
     * @return documentoIdentidad
     */
    private static void validarDocumentoIdentidad(String documentoIdentidad) {
        Pattern pattern = Pattern
                .compile("^\\d+$");
        Matcher mather = pattern.matcher(documentoIdentidad);
        if (!mather.find()) {
            throw new EstructuraUsuarioNoValidaException("El atributo documentoIdentidad debe ser numerico");
        }
    }

    private static boolean isNull(Object campo) {
        if (campo == null) {
            return true;
        }
        return false;
    }
}
