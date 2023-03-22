package com.backend.portfolio.service;

import java.util.List;

import com.backend.portfolio.models.Experiencia;

public interface IExperienciaService {

    public List<Experiencia> verExperiencia();

    public void crearExperiencia (Experiencia exp);

    public void eliminarExperiencia(Long id);

    public Experiencia editarExperiencia (Long id, Experiencia exp);
}
