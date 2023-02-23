package com.pragma.powerup.infrastructure.security.impl;

import com.pragma.powerup.domain.model.Rol;
import com.pragma.powerup.domain.model.Usuario;
import com.pragma.powerup.domain.spi.UsuarioPersistencePort;
import com.pragma.powerup.infrastructure.out.jpa.entity.UsuarioEntity;
import com.pragma.powerup.infrastructure.out.jpa.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserDetailService  implements UserDetailsService {
   private final UsuarioPersistencePort usuarioPersistencePort;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {

       Usuario usuarioByCorreo =usuarioPersistencePort.findBycorreo(correo);

        return new MyUserDetails(usuarioByCorreo);
    }
}
