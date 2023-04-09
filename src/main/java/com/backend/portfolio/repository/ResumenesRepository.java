package com.backend.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.portfolio.models.Resumenes;

public interface ResumenesRepository extends JpaRepository<Resumenes,Long>{
    
}
