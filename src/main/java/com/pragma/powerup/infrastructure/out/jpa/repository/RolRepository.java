package com.pragma.powerup.infrastructure.out.jpa.repository;

import com.pragma.powerup.infrastructure.out.jpa.entity.RolEntity;
import com.pragma.powerup.infrastructure.out.jpa.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RolRepository extends JpaRepository<RolEntity, Long> {

    @Query(value = "SELECT * FROM `roles` WHERE codigo=?1",
            nativeQuery = true)
    RolEntity buscarRolPorCodigo(String codigo);
}
