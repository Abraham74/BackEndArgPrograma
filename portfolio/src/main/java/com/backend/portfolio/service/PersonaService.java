package com.backend.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.portfolio.models.Persona;
import com.backend.portfolio.repository.PersonaRepository;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public void crearPersona(Persona per) {
        personaRepository.save(per);
        
    }

    @Override
    public Persona editarPersona(Long id, Persona per) {
        Persona persona = personaRepository.findById(id).get();

        persona.setNombre(per.getNombre());
        persona.setApellido(per.getApellido());
        persona.setCorreo(per.getCorreo());
        persona.setCelular(per.getCelular());
        persona.setCiudad(per.getCiudad());
        persona.setCuit(per.getCuit());
        persona.setDni(per.getDni());
        persona.setDomicilio(per.getDomicilio());
        persona.setEstado_civil(per.getEstado_civil());
        persona.setFecha_nacimiento(per.getFecha_nacimiento());
        persona.setFreelance(per.getFreelance());
        persona.setGrade(per.getGrade());
        persona.setImage_perfil(per.getImage_perfil());
        persona.setNacionalidad(per.getNacionalidad());
        persona.setOcupacion(per.getOcupacion());
        persona.setSobre_mi(per.getSobre_mi());
        persona.setSobre_mi_r1(per.getSobre_mi_r1());
        persona.setSobre_mi_r2(per.getSobre_mi_r2());

        personaRepository.save(persona);

        return persona;
    }

    @Override
    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public List<Persona> verPersona() {
        return this.personaRepository.findAll();
    }
    

}
