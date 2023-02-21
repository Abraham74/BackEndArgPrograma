package com.backend.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.portfolio.models.Cursos;

public interface CursosRepository extends JpaRepository<Cursos,Long>{
    
}
