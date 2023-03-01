package com.pragma.powerup.infrastructure.exceptionhandler;

import com.pragma.powerup.domain.exception.InformacionUsuarioNoEncontradaFoundException;
import com.pragma.powerup.domain.exception.RolNoValidoException;
import com.pragma.powerup.domain.exception.EstructuraUsuarioNoValidaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String ERROR = "ERROR";
    private static final String STATUS_CODE = "STATUS_CODE";


    @ExceptionHandler(EstructuraUsuarioNoValidaException.class)
    public ResponseEntity<Map<String, String>> handleEstructuraUsuarioNoValidaException(
            EstructuraUsuarioNoValidaException estructuraUsuarioNoValidaException) {

        Map<String, String> stringStringMap = new HashMap<String, String>();
        stringStringMap.put(ERROR, estructuraUsuarioNoValidaException.getMessage());
        stringStringMap.put(STATUS_CODE, HttpStatus.BAD_REQUEST.getReasonPhrase());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(stringStringMap);
    }

    @ExceptionHandler(InformacionUsuarioNoEncontradaFoundException.class)
    public ResponseEntity<Map<String, String>> handleInformacionUsuarioNoEncontradaFoundException(
            InformacionUsuarioNoEncontradaFoundException informacionUsuarioNoEncontradaFoundException) {

        Map<String, String> stringStringMap = new HashMap<String, String>();
        stringStringMap.put(ERROR, informacionUsuarioNoEncontradaFoundException.getMessage());
        stringStringMap.put(STATUS_CODE, HttpStatus.BAD_REQUEST.getReasonPhrase());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(stringStringMap);
    }

    @ExceptionHandler(RolNoValidoException.class)
    public ResponseEntity<Map<String, String>> handleRolNoValidoException(
            RolNoValidoException rolNoValidoException) {

        Map<String, String> stringStringMap = new HashMap<String, String>();
        stringStringMap.put(ERROR, rolNoValidoException.getMessage());
        stringStringMap.put(STATUS_CODE, HttpStatus.NOT_FOUND.getReasonPhrase());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(stringStringMap);
    }

}