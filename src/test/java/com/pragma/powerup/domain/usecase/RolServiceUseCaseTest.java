package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.spi.RolPersistencePort;
import com.pragma.powerup.domain.exception.RolNoValidoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class RolServiceUseCaseTest {
    @InjectMocks
    private RolServiceUseCase rolServiceUseCase;
    @Mock
    private RolPersistencePort rolPersistencePort;

    @Test
    void debeValidarSiUnRolExiste() {
        Mockito.when(rolPersistencePort.validarSiExisteRol(Mockito.any())).thenReturn(true);

        assertTrue(rolServiceUseCase.validarSiExistRol(1L));

    }

    @Test
    void debeValidarSiUnRolNoExiste() {
        Mockito.when(rolPersistencePort.validarSiExisteRol(Mockito.any())).thenThrow(RolNoValidoException.class);
        Assertions.assertThrows(RolNoValidoException.class,
                () ->
                        rolServiceUseCase.validarSiExistRol(1L));

    }
}