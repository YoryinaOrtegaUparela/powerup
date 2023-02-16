package com.pragma.powerup.infrastructure.exception;

public class NoValidRolException extends RuntimeException{

    public NoValidRolException(){
        super();
    }
    public NoValidRolException(String message){
        super(message);
    }
}
