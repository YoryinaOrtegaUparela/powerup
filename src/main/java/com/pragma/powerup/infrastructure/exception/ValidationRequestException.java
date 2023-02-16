package com.pragma.powerup.infrastructure.exception;

public class ValidationRequestException extends RuntimeException {
    public ValidationRequestException(){
        super();
    }

    public ValidationRequestException(String message){
        super(message);
    }


}
