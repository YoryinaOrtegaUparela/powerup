package com.pragma.powerup.infrastructure.out.jpa.repository;

import com.pragma.powerup.infrastructure.out.jpa.entity.RolEntity;
import com.pragma.powerup.infrastructure.out.jpa.entity.UsuarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RolRepository extends JpaRepository<RolEntity, Long> {

    @Query(value = "SELECT * FROM roles WHERE codigo=?1",
            nativeQuery = true)
    Optional<RolEntity> buscarRolPorCodigo(String codigo);

    @Query(value = "SELECT codigo FROM roles ", nativeQuery = true)
    Page<RolEntity> findAllWithPagination( Pageable pageable);

}
