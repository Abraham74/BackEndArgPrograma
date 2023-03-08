package com.backend.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.portfolio.models.Educacion;
import com.backend.portfolio.repository.EducacionRepository;

@Service
public class EducacionService implements IEducacionService{

    @Autowired
    private EducacionRepository educacionrepository;

    @Override
    public void crearEducacion(Educacion edu) {
        educacionrepository.save(edu);
    }

    @Override
    public Educacion editarEducacion(Long id, Educacion edu) {
        Educacion educacion = educacionrepository.findById(id).get();

        educacion.setNombre(edu.getNombre());
        educacion.setResumen_edu(edu.getResumen_edu());
        educacion.setInicio(edu.getInicio());
        educacion.setFin(edu.getFin());
        educacion.setTitulo(edu.getTitulo());

        educacionrepository.save(educacion);

        return educacion;
    }

    @Override
    public void eliminarEducacion(Long id) {
        educacionrepository.deleteById(id);
    }

    @Override
    public List<Educacion> verEducacion() {
        return this.educacionrepository.findAll();
    }
}
