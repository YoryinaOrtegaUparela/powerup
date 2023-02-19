package com.pragma.powerup.infrastructure.security;

import com.pragma.powerup.domain.api.SecurityPasswordServicePort;
import com.pragma.powerup.domain.spi.SecurityPasswordPort;
import com.pragma.powerup.domain.usecase.EncriptarUseCase;
import com.pragma.powerup.infrastructure.security.impl.BcryptSecurityPasswordPortImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfiguration {

    /**
     * Bean para Encodear Password
     *
     * @return
     */
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * Inyeccion del SPI correspondiente
     *
     * @return
     */
    @Bean
    public SecurityPasswordPort securityPassword() {
        return new BcryptSecurityPasswordPortImpl(encoder());
    }

    /**
     * Inyeccion de API correspondiente
     *
     * @return
     */
    @Bean
    public SecurityPasswordServicePort securityPasswordServicePort() {
        return new EncriptarUseCase(securityPassword());
    }

    /*
    Configuracion de Seguridad Http
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests()
                .antMatchers("/api/v1/usuario/*").permitAll()
                .anyRequest().authenticated();
        return http.build();
    }
}
