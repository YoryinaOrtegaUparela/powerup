package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.RolServicePort;
import com.pragma.powerup.domain.exception.NoValidRolException;
import com.pragma.powerup.domain.exception.UserDataNotFoundException;
import com.pragma.powerup.domain.exception.UserNotValidStructureException;
import com.pragma.powerup.domain.model.Usuario;
import com.pragma.powerup.domain.spi.SecurityPasswordPort;
import com.pragma.powerup.domain.spi.UsuarioPersistencePort;
import com.pragma.powerup.domain.usecase.factory.UsuarioDataTest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
class UsuarioServiceUseCaseTest {

    @InjectMocks
    private UsuarioServiceUseCase usuarioServiceUseCase;
    @Mock
    private UsuarioPersistencePort usuarioPersistencePort;

    @Mock
    private RolServicePort rolServicePort;

    @Mock
    private SecurityPasswordPort securityPasswordPort;


    @Test
    void debecrearUsuario() {
        //GIVEN
        Usuario nuevoUsuario = UsuarioDataTest.getUsuarioNuevo();
        //WHENs
        Mockito.when(rolServicePort.validateExistRol(Mockito.any())).thenReturn(true);
        Mockito.when(securityPasswordPort.encriptarContrasena(Mockito.any())).thenReturn("#3$4#RARO");


    //Validar el guardarUsuario
        usuarioServiceUseCase.crearUsuario(nuevoUsuario);
        //Verificar guardado
        Mockito.verify(usuarioPersistencePort).guardarUsuario(nuevoUsuario);
    }

    @Test
    void NodebecrearUsuarioPorqueElRolNoExiste() {
        //GIVEN
        Usuario nuevoUsuario = UsuarioDataTest.getUsuarioNuevo();
        //WHENs
        Mockito.when(rolServicePort.validateExistRol(Mockito.any())).thenThrow(NoValidRolException.class);
        Mockito.when(securityPasswordPort.encriptarContrasena(Mockito.any())).thenReturn("#3$4#RARO");

        //Verificar que lanza excepcion por estructura invalida
        Assertions.assertThrows(NoValidRolException.class,
                () ->  //Validar el guardarUsuario
                        usuarioServiceUseCase.crearUsuario(nuevoUsuario));

    }

    @Test
    void noDebecrearUsuarioPorEstructuraEmailIncorrecto() {
        //GIVEN
        Usuario nuevoUsuario = UsuarioDataTest.getUsuarioEmailIncorrecto();
        // Usuario nuevoUsuario = UsuarioDataTest.getUsuarioNuevo();

        //Verificar que lanza excepcion por estructura invalida
        Assertions.assertThrows(UserNotValidStructureException.class,
                () ->  //Validar el guardarUsuario
                        usuarioServiceUseCase.crearUsuario(nuevoUsuario));
    }

    @Test
    void noDebecrearUsuarioPorCampoObligatorioFaltante() {
        //GIVEN
        Usuario nuevoUsuario = UsuarioDataTest.getUsuarioDatoFaltante();

        //Verificar guardado
        Assertions.assertThrows(UserDataNotFoundException.class,
                () ->  //Validar el guardarUsuario
                        usuarioServiceUseCase.crearUsuario(nuevoUsuario));
    }

    @Test
    void noDebecrearUsuarioPorDocumentoDeIdentidadNoNumerico() {
        //GIVEN
        Usuario nuevoUsuario = UsuarioDataTest.getUsuarioDocumentoIdentidadNoNumerico();

        //Verificar guardado
        Assertions.assertThrows(UserNotValidStructureException.class,
                () ->  //Validar el guardarUsuario
                        usuarioServiceUseCase.crearUsuario(nuevoUsuario));
    }

    @Test
    void noDebecrearUsuarioPorTelefonoExedeMaximo() {
        //GIVEN
        Usuario nuevoUsuario = UsuarioDataTest.getUsuarioTelefonoMaximoCaracteres();

        //Verificar guardado
        Assertions.assertThrows(UserNotValidStructureException.class,
                () ->  //Validar el guardarUsuario
                        usuarioServiceUseCase.crearUsuario(nuevoUsuario));
    }


}