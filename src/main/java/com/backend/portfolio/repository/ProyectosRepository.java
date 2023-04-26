package com.backend.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.portfolio.models.Proyectos;

public interface ProyectosRepository extends JpaRepository<Proyectos,Long>{
    
}
