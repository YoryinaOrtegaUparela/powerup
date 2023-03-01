package com.pragma.powerup.infrastructure.input.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.powerup.application.dto.request.UsuarioRequestDto;
import com.pragma.powerup.application.dto.response.UsuarioResponseDto;
import com.pragma.powerup.application.handler.UsuarioHandler;
import com.pragma.powerup.domain.exception.EstructuraUsuarioNoValidaException;
import com.pragma.powerup.domain.exception.RolNoValidoException;
import com.pragma.powerup.domain.model.Rol;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = UsuarioRestController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
class UsuarioRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UsuarioHandler usuarioHandler;


    @Test
    void creaPropietario() throws Exception {
        UsuarioRequestDto usuarioRequestDto = new UsuarioRequestDto();
        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();
        usuarioResponseDto.setNombre("pepo");
        usuarioResponseDto.setCodigoRol("PROP");
        usuarioResponseDto.setRol(Rol.PROPIETARIO);
        usuarioResponseDto.setClave("#asd#asd#asd");


        String request = objectMapper.writeValueAsString(usuarioRequestDto);
        String response = objectMapper.writeValueAsString(usuarioResponseDto);

        when(usuarioHandler.crearUsuario(Mockito.any())).thenReturn(usuarioResponseDto);

        this.mockMvc.perform(post("/api/v1/usuario/propietario").content(request)
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString(response)));
    }

    @Test
    void responderConBadRequest() throws Exception {
        UsuarioRequestDto usuarioRequestDto = new UsuarioRequestDto();
        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();
        usuarioResponseDto.setNombre("pepo");
        usuarioResponseDto.setCodigoRol("PROP");
        usuarioResponseDto.setRol(Rol.PROPIETARIO);
        usuarioResponseDto.setClave("#asd#asd#asd");

        String jsonDeRespuesta="{\"ERROR\":null,\"STATUS_CODE\":\"Bad Request\"}";

        String request = objectMapper.writeValueAsString(usuarioRequestDto);

        when(usuarioHandler.crearUsuario(Mockito.any())).thenThrow(EstructuraUsuarioNoValidaException.class);

        this.mockMvc.perform(post("/api/v1/usuario/propietario").content(request)
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString(jsonDeRespuesta)));
    }

    @Test
    void crearEmpleado() throws Exception {

        UsuarioRequestDto usuarioRequestDto = new UsuarioRequestDto();
        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();
        usuarioResponseDto.setNombre("pepo");
        usuarioResponseDto.setCodigoRol("EMPLE");
        usuarioResponseDto.setRol(Rol.EMPLEADO);
        usuarioResponseDto.setClave("#asd#asd#asd");

        String request = objectMapper.writeValueAsString(usuarioRequestDto);
        String response = objectMapper.writeValueAsString(usuarioResponseDto);

        when(usuarioHandler.crearUsuario(Mockito.any())).thenReturn(usuarioResponseDto);

        this.mockMvc.perform(post("/api/v1/usuario/empleado").content(request)
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString(response)));
    }

    @Test
    void crearCliente() throws Exception {

        UsuarioRequestDto usuarioRequestDto = new UsuarioRequestDto();
        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();
        usuarioResponseDto.setNombre("Susanito");
        usuarioResponseDto.setCodigoRol("CLIENT");
        usuarioResponseDto.setRol(Rol.CLIENTE);
        usuarioResponseDto.setClave("#asd#asd#asd");

        String request = objectMapper.writeValueAsString(usuarioRequestDto);
        String response = objectMapper.writeValueAsString(usuarioResponseDto);

        when(usuarioHandler.crearUsuario(Mockito.any())).thenReturn(usuarioResponseDto);

        this.mockMvc.perform(post("/api/v1/usuario/cliente").content(request)
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString(response)));
    }

    @Test
    void validarRolUsuario() throws Exception {

        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();
        usuarioResponseDto.setNombre("pepo");
        usuarioResponseDto.setCodigoRol("ADMIN");
        usuarioResponseDto.setRol(Rol.ADMINISTRADOR);
        usuarioResponseDto.setClave("#asd#asd#asd");

        String response = objectMapper.writeValueAsString(usuarioResponseDto);

        when(usuarioHandler.recuperarUsuarioPorId(2L)).thenReturn(usuarioResponseDto);

        this.mockMvc.perform(get("/api/v1/usuario/validaRolUsuario/{usuarioId}", 2L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(response)));
    }

    @Test
    void validarUsuarioPorCorreo() {
    }
}