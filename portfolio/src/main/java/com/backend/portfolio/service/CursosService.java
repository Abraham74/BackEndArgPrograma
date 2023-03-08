package com.backend.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.portfolio.models.Cursos;
import com.backend.portfolio.repository.CursosRepository;

@Service
public class CursosService implements ICursosService{
    
    @Autowired
    private CursosRepository cursosRepository;

    @Override
    public void crearCurso(Cursos cur) {
        cursosRepository.save(cur);
        
    }

    @Override
    public Cursos editarCurso(Long id, Cursos cur) {
        Cursos cursos = cursosRepository.findById(id).get();

        cursos.setNombre(cur.getNombre());
        cursos.setAutor(cur.getAutor());
        cursos.setFecha(cur.getFecha());

        cursosRepository.save(cursos);

        return cursos;
    }

    @Override
    public void eliminarCurso(Long id) {
        cursosRepository.deleteById(id);
    }

    @Override
    public List<Cursos> verCursos() {
        return this.cursosRepository.findAll();
    }

}
