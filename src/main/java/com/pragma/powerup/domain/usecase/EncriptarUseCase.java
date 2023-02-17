package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.SecurityPasswordServicePort;
import com.pragma.powerup.domain.spi.SecurityPasswordPort;

public class EncriptarUseCase implements SecurityPasswordServicePort {

    private SecurityPasswordPort securityPasswordPort;

    public EncriptarUseCase(SecurityPasswordPort securityPasswordPort) {
        this.securityPasswordPort = securityPasswordPort;
    }

    @Override
    public String encriptarContrasena(String contrasena) {
        return securityPasswordPort.encriptarContrasena(contrasena);
    }
}
