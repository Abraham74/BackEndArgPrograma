package com.backend.portfolio.security.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.portfolio.security.Entity.Rol;
import com.backend.portfolio.security.Enums.RolNombre;

public interface IRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
