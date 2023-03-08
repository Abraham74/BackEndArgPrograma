package com.backend.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.portfolio.models.Experiencia;
import com.backend.portfolio.repository.ExperienciaRepository;

@Service
public class ExperienciaService implements IExperienciaService {

    @Autowired
    private ExperienciaRepository experienciaRepository;

    @Override
    public void crearExperiencia(Experiencia exp) {
        experienciaRepository.save(exp);
        
    }

    @Override
    public Experiencia editarExperiencia(Long id, Experiencia exp) {
        Experiencia experiencia = experienciaRepository.findById(id).get();

        experiencia.setNombre(exp.getNombre());
        experiencia.setInicio(exp.getInicio());
        experiencia.setFin(exp.getFin());
        experiencia.setTarea1(exp.getTarea1());
        experiencia.setTarea2(exp.getTarea2());
        experiencia.setTarea3(exp.getTarea3());
        experiencia.setTarea4(exp.getTarea4());

        experienciaRepository.save(experiencia);

        return experiencia;
    }

    @Override
    public void eliminarExperiencia(Long id) {
        experienciaRepository.deleteById(id);
    }

    @Override
    public List<Experiencia> verExperiencia() {
        return this.experienciaRepository.findAll();
    }
}
