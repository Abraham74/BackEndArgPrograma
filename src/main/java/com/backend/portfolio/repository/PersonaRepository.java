package com.backend.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.portfolio.models.Persona;

public interface PersonaRepository extends JpaRepository<Persona,Long>{
    
}
