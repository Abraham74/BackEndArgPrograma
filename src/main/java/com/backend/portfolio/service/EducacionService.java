package com.backend.portfolio.service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Educacion> getOne(long id){
        return educacionrepository.findById(id);
    }

    public boolean existsById(Long id){
        return educacionrepository.existsById(id);
    }

    @Override
    public Educacion editarEducacion(Long id, Educacion edu) {
        Educacion educacion = educacionrepository.findById(id).get();

        educacion.setNombre(edu.getNombre() == null ? educacion.getNombre() : edu.getNombre());
        educacion.setResumen_edu(edu.getResumen_edu() == null ? educacion.getResumen_edu() : edu.getResumen_edu());
        educacion.setInicio(edu.getInicio() == 0 ? educacion.getInicio() : edu.getInicio());
        educacion.setFin(edu.getFin() == null ? educacion.getFin() : edu.getFin());
        educacion.setTitulo(edu.getTitulo() == null ? educacion.getTitulo() : edu.getTitulo());

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
