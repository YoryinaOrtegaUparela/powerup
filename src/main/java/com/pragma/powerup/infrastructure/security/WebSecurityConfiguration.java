package com.pragma.powerup.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class WebSecurityConfiguration   {

    /**
     * Bean para Encodear Password
     * @return
     */
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
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
