package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.UsuarioRequestDto;
import com.pragma.powerup.application.dto.response.UsuarioResponseDto;
import com.pragma.powerup.application.handler.UsuarioHandler;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(description = "Permitir la Creacion de un usuario dentro del sistema")
    @PostMapping("/crearUsuario")
    public ResponseEntity<UsuarioResponseDto> crearUsuario(@RequestBody UsuarioRequestDto usuarioRequestDto) {
        UsuarioResponseDto usuarioResponseDto = usuarioHandler.guardarUsuario(usuarioRequestDto);

        return new ResponseEntity<UsuarioResponseDto>(usuarioResponseDto, HttpStatus.CREATED);

    }
}
