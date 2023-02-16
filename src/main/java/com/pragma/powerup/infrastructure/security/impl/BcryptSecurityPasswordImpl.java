package com.pragma.powerup.infrastructure.security.impl;

import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import com.pragma.powerup.infrastructure.exception.ValidationRequestException;
import com.pragma.powerup.infrastructure.security.SecurityPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BcryptSecurityPasswordImpl implements SecurityPassword {

    private PasswordEncoder passwordEncoder;

    public BcryptSecurityPasswordImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encriptarContrasena(String contrasena) {
        String encode = passwordEncoder.encode(contrasena);
        return encode;
    }
}
