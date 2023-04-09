package com.backend.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.portfolio.models.Tareas;

public interface TareasRepository extends JpaRepository<Tareas,Long>{
    
}
