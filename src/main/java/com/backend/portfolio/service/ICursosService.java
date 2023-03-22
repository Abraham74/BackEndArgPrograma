package com.backend.portfolio.service;

import java.util.List;

import com.backend.portfolio.models.Cursos;

public interface ICursosService {

    public List<Cursos> verCursos();

    public void crearCurso (Cursos cur);

    public void eliminarCurso(Long id);

    public Cursos editarCurso (Long id, Cursos cur);
}
