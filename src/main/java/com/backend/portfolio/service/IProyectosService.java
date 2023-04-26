package com.backend.portfolio.service;

import java.util.List;

import com.backend.portfolio.models.Proyectos;

public interface IProyectosService {
    
    public List<Proyectos> verProyectos();

    public void crearProyecto (Proyectos proyecto);

    public void eliminarProyecto(Long id);

    public Proyectos editarProyecto (Long id, Proyectos proy);

}
