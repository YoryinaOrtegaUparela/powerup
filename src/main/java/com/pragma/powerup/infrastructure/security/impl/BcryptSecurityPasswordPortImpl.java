package com.pragma.powerup.infrastructure.security.impl;

import com.pragma.powerup.domain.spi.SecurityPasswordPort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


public class BcryptSecurityPasswordPortImpl implements SecurityPasswordPort {

    private PasswordEncoder passwordEncoder;

    public BcryptSecurityPasswordPortImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encriptarContrasena(String contrasena) {
        String encode = passwordEncoder.encode(contrasena);
        return encode;
    }
}
