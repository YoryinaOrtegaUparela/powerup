package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.UsuarioRequestDto;
import com.pragma.powerup.application.handler.UsuarioHandler;
import com.pragma.powerup.domain.spi.SecurityPasswordPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioRestController {

    private UsuarioHandler usuarioHandler;

    public UsuarioRestController(UsuarioHandler usuarioHandler) {
        this.usuarioHandler = usuarioHandler;
    }

    @PostMapping("/")
    public ResponseEntity<Void> crearUsuario(@Valid @RequestBody UsuarioRequestDto usuarioRequestDto) {
        usuarioHandler.guardarUsuario(usuarioRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
