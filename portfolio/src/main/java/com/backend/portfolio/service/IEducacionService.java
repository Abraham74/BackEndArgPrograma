package com.backend.portfolio.service;

import java.util.List;

import com.backend.portfolio.models.Educacion;

public interface IEducacionService {
    
    public List<Educacion> verEducacion();

    public void crearEducacion (Educacion edu);

    public void eliminarEducacion(Long id);

    public Educacion editarEducacion (Long id, Educacion edu);
}
