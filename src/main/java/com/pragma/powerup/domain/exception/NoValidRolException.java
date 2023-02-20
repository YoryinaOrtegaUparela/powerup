package com.pragma.powerup.domain.exception;

public class NoValidRolException extends RuntimeException{

    public NoValidRolException(){
        super();
    }
    public NoValidRolException(String message){
        super(message);
    }
}
