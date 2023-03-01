package com.pragma.powerup.domain.exception;

public class RolNoValidoException extends RuntimeException{

    public RolNoValidoException(){
        super();
    }
    public RolNoValidoException(String message){
        super(message);
    }
}
