package com.pragma.powerup.infrastructure.out.jpa.mapper;

import com.pragma.powerup.domain.model.Usuario;
import com.pragma.powerup.infrastructure.out.jpa.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface UsuarioEntityMapper {

    /*
    Convierte un usuario a usuario entidad
     */
    UsuarioEntity usuarioToUsuarioEntity(Usuario usuario);

}
