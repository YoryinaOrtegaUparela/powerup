package com.pragma.powerup.domain.exception;

public class UserNotValidStructureException extends RuntimeException {
    public UserNotValidStructureException(){
        super();
    }

    public UserNotValidStructureException(String message){
        super(message);
    }


}
