package com.backend.portfolio.service;

import java.util.List;

import com.backend.portfolio.DTO.ExperienciaDTO;
import com.backend.portfolio.models.Experiencias;

public interface IExperienciaService {

    public List<ExperienciaDTO> verExperiencia();

    public Experiencias crearExperiencia (ExperienciaDTO exp);

    public void eliminarExperiencia(Long id);

    public ExperienciaDTO editarExperiencia (ExperienciaDTO exp);
}
