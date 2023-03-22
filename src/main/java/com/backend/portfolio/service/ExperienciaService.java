package com.backend.portfolio.service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Experiencia> getOne(long id){
        return experienciaRepository.findById(id);
    }

    public boolean existsById(Long id){
        return experienciaRepository.existsById(id);
    }

    @Override
    public Experiencia editarExperiencia(Long id, Experiencia exp) {
        Experiencia experiencia = experienciaRepository.findById(id).get();

        experiencia.setNombre(exp.getNombre() == null ? experiencia.getNombre() : exp.getNombre());
        experiencia.setInicio(exp.getInicio() == 0 ? experiencia.getInicio() : exp.getInicio());
        experiencia.setFin(exp.getFin() == null ? experiencia.getFin() : exp.getFin());
        experiencia.setTarea1(exp.getTarea1() == null ? experiencia.getTarea1() : exp.getTarea1());
        experiencia.setTarea2(exp.getTarea2() == null ? experiencia.getTarea2() : exp.getTarea2());
        experiencia.setTarea3(exp.getTarea3() == null ? experiencia.getTarea3() : exp.getTarea3());
        experiencia.setTarea4(exp.getTarea4() == null ? experiencia.getTarea4() : exp.getTarea4());

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
