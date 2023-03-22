package com.backend.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.portfolio.models.Educacion;

public interface EducacionRepository extends JpaRepository<Educacion,Long>{
    
}
