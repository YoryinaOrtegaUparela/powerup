package com.pragma.powerup.domain.exception;

public class UserDataNotFoundException extends RuntimeException {
    public UserDataNotFoundException(){
        super();
    }

    public UserDataNotFoundException(String message){
        super(message);
    }


}
