package com.backend.portfolio.service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Cursos> getOne(long id){
        return cursosRepository.findById(id);
    }

    public boolean existsById(Long id){
        return cursosRepository.existsById(id);
    }

    @Override
    public Cursos editarCurso(Long id, Cursos cur) {
        Cursos cursos = cursosRepository.findById(id).get();

        cursos.setNombre(cur.getNombre() == null ? cursos.getNombre() : cur.getNombre());
        cursos.setAutor(cur.getAutor() == null ? cursos.getAutor() : cur.getAutor());
        cursos.setFecha(cur.getFecha() == null ? cursos.getFecha() : cur.getFecha());

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
