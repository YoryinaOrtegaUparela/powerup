package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.domain.api.RolServicePort;
import com.pragma.powerup.domain.api.UsuarioServicePort;
import com.pragma.powerup.domain.spi.RolPersistencePort;
import com.pragma.powerup.domain.spi.UsuarioPersistencePort;
import com.pragma.powerup.domain.usecase.RolServiceUseCase;
import com.pragma.powerup.domain.usecase.UsuarioServiceUseCase;
import com.pragma.powerup.infrastructure.out.jpa.adapter.RolPersistenceAdapter;
import com.pragma.powerup.infrastructure.out.jpa.adapter.UsuarioPersistenceAdapter;
import com.pragma.powerup.infrastructure.out.jpa.mapper.UsuarioEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.RolRepository;
import com.pragma.powerup.infrastructure.out.jpa.repository.UsuarioRepository;
import com.pragma.powerup.domain.spi.SecurityPasswordPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioEntityMapper usuarioEntityMapper;
    private final RolRepository rolRepository;


    @Bean
    public UsuarioPersistencePort usuarioPersistencePort(){
        return new UsuarioPersistenceAdapter(usuarioEntityMapper, usuarioRepository);
    }

    @Bean
    public UsuarioServicePort usuarioServicePort(){
        return new UsuarioServiceUseCase(usuarioPersistencePort());
    }

    @Bean
    public RolPersistencePort rolPersistencePort(){
        return new RolPersistenceAdapter(rolRepository);
    }

    @Bean
    public RolServicePort rolServicePort(){
        return new RolServiceUseCase(rolPersistencePort());
    }


}