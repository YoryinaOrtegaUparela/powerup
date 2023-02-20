package com.pragma.powerup.infrastructure.exceptionhandler;

import com.pragma.powerup.domain.exception.UserDataNotFoundException;
import com.pragma.powerup.domain.exception.NoValidRolException;
import com.pragma.powerup.domain.exception.UserNotValidStructureException;
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




    @ExceptionHandler(UserNotValidStructureException.class)
    public ResponseEntity<Map<String, String>> handleValidationRequestException(
            UserNotValidStructureException userNotValidStructureException) {

        Map<String, String> stringStringMap = new HashMap<String, String>();
        stringStringMap.put(ERROR, userNotValidStructureException.getMessage());
        stringStringMap.put(STATUS_CODE, HttpStatus.BAD_REQUEST.getReasonPhrase());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(stringStringMap);
    }

    @ExceptionHandler(UserDataNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleValidationRequestException(
            UserDataNotFoundException userDataNotFoundException) {

        Map<String, String> stringStringMap = new HashMap<String, String>();
        stringStringMap.put(ERROR, userDataNotFoundException.getMessage());
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