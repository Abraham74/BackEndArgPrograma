package com.backend.portfolio.service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Persona> getOne(long id){
        return personaRepository.findById(id);
    }

    public boolean existsById(Long id){
        return personaRepository.existsById(id);
    }

    @Override
    public Persona editarPersona(Long id, Persona per) {
        Persona persona = personaRepository.findById(id).get();

        persona.setNombre(per.getNombre() == null ? persona.getNombre() : per.getNombre() );
        persona.setApellido(per.getApellido() == null ? persona.getApellido() : per.getApellido());
        persona.setCorreo(per.getCorreo() == null ? persona.getCorreo() : per.getCorreo());
        persona.setCelular(per.getCelular() == null ? persona.getCelular() : per.getCelular());
        persona.setCiudad(per.getCiudad() == null ? persona.getCiudad() : per.getCiudad());
        persona.setCuit(per.getCuit() == null ? persona.getCuit() : per.getCuit());
        persona.setDni(per.getDni() == 0 ? persona.getDni() : per.getDni());
        persona.setDomicilio(per.getDomicilio() == null ? persona.getDomicilio() : per.getDomicilio());
        persona.setEstado_civil(per.getEstado_civil() == null ? persona.getEstado_civil() : per.getEstado_civil());
        persona.setFecha_nacimiento(per.getFecha_nacimiento() == null ? persona.getFecha_nacimiento() : per.getFecha_nacimiento());
        persona.setFreelance(per.getFreelance() == null ? persona.getFreelance() : per.getFreelance());
        persona.setNivelIngles(per.getNivelIngles() == null ? persona.getNivelIngles() : per.getNivelIngles());
        persona.setImage_perfil(per.getImage_perfil() == null ? persona.getImage_perfil() : per.getImage_perfil());
        persona.setNacionalidad(per.getNacionalidad() == null ? persona.getNacionalidad() : per.getNacionalidad());
        persona.setOcupacion(per.getOcupacion() == null ? persona.getOcupacion() : per.getOcupacion());
        persona.setSobre_mi(per.getSobre_mi() == null ? persona.getSobre_mi() : per.getSobre_mi());
        persona.setSobre_mi_r1(per.getSobre_mi_r1() == null ? persona.getSobre_mi_r1() : per.getSobre_mi_r1());
        persona.setSobre_mi_r2(per.getSobre_mi_r2() == null ? persona.getSobre_mi_r2() : per.getSobre_mi_r2());

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
