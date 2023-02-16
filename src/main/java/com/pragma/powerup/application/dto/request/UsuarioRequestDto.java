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
    private Long documentoIdentidad;

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
     * Método para validar que el telefono celular cuente con máximo 13 caracteres
     * @param celular
     * @return celular validado
     */
    private String validarTamanoCelular(String celular) {
        if (celular.length() > 13) {
            throw new ValidationRequestException("número de caracteres mayor a 13");
        }
        return celular;
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
        this.celular = validarTamanoCelular(celular);
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

    public Long getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(Long documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
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
