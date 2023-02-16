package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.UsuarioRequestDto;
import com.pragma.powerup.application.handler.UsuarioHandler;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import com.pragma.powerup.infrastructure.exceptionhandler.ExceptionResponse;
import com.pragma.powerup.infrastructure.security.SecurityPassword;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioRestController {

    private UsuarioHandler usuarioHandler;
    private SecurityPassword securityPassword;

    public UsuarioRestController(UsuarioHandler usuarioHandler, SecurityPassword securityPassword) {
        this.usuarioHandler = usuarioHandler;
        this.securityPassword = securityPassword;
    }

    @PostMapping("/")
    public ResponseEntity<Void> crearUsuario(@Valid @RequestBody UsuarioRequestDto usuarioRequestDto) {
        String claveEncriptada = securityPassword.encriptarContrasena(usuarioRequestDto.getClave());
        usuarioRequestDto.setClave(claveEncriptada);
        usuarioHandler.guardarUsuario(usuarioRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
