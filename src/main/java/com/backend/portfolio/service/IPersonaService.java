package com.backend.portfolio.service;

import java.util.List;

import com.backend.portfolio.DTO.PersonaDTO;
import com.backend.portfolio.models.Persona;

public interface IPersonaService {
    public List<PersonaDTO> verPersona();

    public Persona crearPersona (PersonaDTO per);

    public void eliminarPersona(Long id);

    public PersonaDTO editarPersona (PersonaDTO per);
}
