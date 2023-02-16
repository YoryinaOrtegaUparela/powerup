package com.pragma.powerup.infrastructure.exceptionhandler;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import com.pragma.powerup.infrastructure.exception.NoValidRolException;
import com.pragma.powerup.infrastructure.exception.ValidationRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String ERROR = "ERROR";
    private static final String STATUS_CODE = "STATUS_CODE";


    /**
     * Manejador de excepcion cuando no se encuentre la información solicitada
     *
     * @param noDataFoundException
     * @return
     */
    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            NoDataFoundException noDataFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(ERROR, ExceptionResponse.NO_DATA_FOUND.getMessage()));
    }


    @ExceptionHandler(ValidationRequestException.class)
    public ResponseEntity<Map<String, String>> handleValidationRequestException(
            ValidationRequestException validationRequestException) {

        Map<String, String> stringStringMap = new HashMap<String, String>();
        stringStringMap.put(ERROR, validationRequestException.getMessage());
        stringStringMap.put(STATUS_CODE, HttpStatus.BAD_REQUEST.getReasonPhrase());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(stringStringMap);
    }

    @ExceptionHandler(NoValidRolException.class)
    public ResponseEntity<Map<String, String>> handleNoValidRolException(
            NoValidRolException noValidRolException) {

        Map<String, String> stringStringMap = new HashMap<String, String>();
        stringStringMap.put(ERROR, noValidRolException.getMessage());
        stringStringMap.put(STATUS_CODE, HttpStatus.NOT_FOUND.getReasonPhrase());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(stringStringMap);
    }

}