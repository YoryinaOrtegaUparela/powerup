package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.UsuarioRequestDto;
import com.pragma.powerup.application.dto.response.UsuarioResponseDto;
import com.pragma.powerup.application.handler.UsuarioHandler;
import com.pragma.powerup.domain.model.Rol;
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





    @Operation(description = "Permitir la Creacion de un propietario dentro del sistema")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/creaPropietario")
    public ResponseEntity<UsuarioResponseDto> creaPropietario(@RequestBody UsuarioRequestDto usuarioRequestDto) {

        usuarioRequestDto.setRol(Rol.PROPIETARIO);
        UsuarioResponseDto usuarioResponseDto = usuarioHandler.guardarUsuario(usuarioRequestDto);
        return new ResponseEntity<UsuarioResponseDto>(usuarioResponseDto, HttpStatus.CREATED);

    }

    @Operation(description = "Permitir la Creacion de un propietario dentro del sistema")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/crearEmpleado")
    public ResponseEntity<UsuarioResponseDto> crearEmpleado(@RequestBody UsuarioRequestDto usuarioRequestDto) {

        usuarioRequestDto.setRol(Rol.EMPLEADO);
        UsuarioResponseDto usuarioResponseDto = usuarioHandler.guardarUsuario(usuarioRequestDto);
        return new ResponseEntity<UsuarioResponseDto>(usuarioResponseDto, HttpStatus.CREATED);

    }

    @Operation(description = "Permitir la Creacion de un propietario dentro del sistema")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/crearCliente")
    public ResponseEntity<UsuarioResponseDto> crearCliente(@RequestBody UsuarioRequestDto usuarioRequestDto) {

        usuarioRequestDto.setRol(Rol.CLIENTE);
        UsuarioResponseDto usuarioResponseDto = usuarioHandler.guardarUsuario(usuarioRequestDto);
        return new ResponseEntity<UsuarioResponseDto>(usuarioResponseDto, HttpStatus.CREATED);

    }



    @Operation(description = "Retornar dato de id , rol y nombre para un Usuario ")
    @GetMapping("/validarRolUsuario/{usuarioId}")
    public ResponseEntity<UsuarioResponseDto> validarRolUsuario(@PathVariable("usuarioId") Long usuarioId) {
        UsuarioResponseDto usuarioResponseDto = usuarioHandler.recuperarUsuarioPorId(usuarioId);

        return new ResponseEntity<UsuarioResponseDto>(usuarioResponseDto, HttpStatus.OK);

    }
}
