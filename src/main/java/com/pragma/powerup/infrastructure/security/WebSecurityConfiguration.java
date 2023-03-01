package com.pragma.powerup.infrastructure.security;

import com.pragma.powerup.domain.spi.SecurityPasswordPort;
import com.pragma.powerup.infrastructure.security.impl.BcryptSecurityPasswordPortImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@AllArgsConstructor
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

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //Se desabilita csrf para evitar configuraciones adicionales ante ataques de seguridad
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/api/v1/usuario/creaPropietario").hasRole("ADMIN")
                .antMatchers("/api/v1/usuario/crearEmpleado").hasRole("PROP")
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/api/v1/usuario/crearUsuario").hasRole("ADMIN")
//                .antMatchers("/api/v1/usuario/validarRolUsuario/**").hasRole("ADMIN")
                .and().httpBasic();
        return http.build();
    }



}
