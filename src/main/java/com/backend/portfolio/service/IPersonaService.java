package com.backend.portfolio.service;

import java.util.List;

import com.backend.portfolio.models.Persona;

public interface IPersonaService {
    public List<Persona> verPersona();

    public void crearPersona (Persona per);

    public void eliminarPersona(Long id);

    public Persona editarPersona (Long id, Persona per);
}
