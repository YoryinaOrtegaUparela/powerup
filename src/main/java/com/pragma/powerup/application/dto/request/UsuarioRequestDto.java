package com.pragma.powerup.application.dto.request;

import com.pragma.powerup.infrastructure.exception.ValidationRequestException;

import javax.validation.constraints.NotNull;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que define la estructura que debe tener la petición de Usuarios
 */
public class UsuarioRequestDto {

    @NotNull(message = "El atributo nombre es obligatorio")
    private String nombre;
    @NotNull(message = "El atributo apellido es obligatorio")
    private String apellido;

    @NotNull(message = "El atributo documento de Identidad es obligatorio")
    private String documentoIdentidad;

    @NotNull(message = "El atributo celular es obligatorio")
    private String celular;

    @NotNull(message = "El atributo correo es obligatorio")
    private String correo;

    @NotNull(message = "El atributo clave es obligatorio")
    private String clave;

    @NotNull(message = "El atributo idRol es obligatorio")
    private Long idRol;


    /**
     * Método para validar que la estructura de un correo se encuentra bien definida
     *
     * @param correo
     * @return correo validado correctamente
     */
    private String validarCorreo(String correo) {
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        if (mather.find()) {
            return correo;
        } else {
            throw new ValidationRequestException("El formato del correo no es valido");
        }
    }

    /**
     * Validar si un numero de celular es valido para el dominio de la Aplicacion
     * @param celular
     * @return
     */
    private boolean celularEsValido(String celular) {
        if (estructuraCelularEsCorrecta(celular) && tamanoCelularEsCorrecto(celular)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para validar que el telefono celular cuente con máximo 13 caracteres
     *
     * @param celular
     * @return celular validado
     */
    private boolean tamanoCelularEsCorrecto(String celular) {
        if (celular.length() > 13) {
            throw new ValidationRequestException("El número de caracteres del atributo celular es mayor a 13");
        }
        return true;
    }

    /**
     * Método para validar que el atributo celular sea unicamente numerico y pueda contener el símbolo +
     *
     * @param celular
     * @return celular
     */
    private boolean estructuraCelularEsCorrecta(String celular) {
        Pattern pattern = Pattern
                .compile("^\\+?\\d+$");
        Matcher mather = pattern.matcher(celular);
        if (mather.find()) {
            return true;
        } else {
            throw new ValidationRequestException("El atributo celular debe ser numerico y puede iniciar con +");
        }
    }

    /**
     * Método para verificar que el documento de identidad sea solo numerico
     * @param documentoIdentidad
     * @return documentoIdentidad
     */
    private String verificarDocumentoIdentidad(String documentoIdentidad) {
        Pattern pattern = Pattern
                .compile("^\\d+$");
        Matcher mather = pattern.matcher(documentoIdentidad);
        if (mather.find()) {
            return documentoIdentidad;
        } else {
            throw new ValidationRequestException("El atributo documentoIdentidad debe ser numerico");
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = validarCorreo(correo);
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        if (celularEsValido(celular)) {
            this.celular = celular;
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = verificarDocumentoIdentidad(documentoIdentidad);
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }
}
