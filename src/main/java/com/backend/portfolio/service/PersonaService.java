package com.backend.portfolio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.portfolio.DTO.PersonaDTO;
import com.backend.portfolio.DTO.ResumenesDTO;
import com.backend.portfolio.models.Persona;
import com.backend.portfolio.models.Resumenes;
import com.backend.portfolio.repository.PersonaRepository;
import com.backend.portfolio.repository.ResumenesRepository;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private ResumenesRepository resumenesRepository;

    @Override
    public Persona crearPersona(PersonaDTO personaDTO) {
        Persona persona = new Persona();
        persona.setNombre(personaDTO.getNombre());
        persona.setApellido(personaDTO.getApellido());
        persona.setFecha_nacimiento(personaDTO.getFecha_nacimiento());
        persona.setNacionalidad(personaDTO.getNacionalidad());
        persona.setCorreo(personaDTO.getCorreo());
        persona.setOcupacion(personaDTO.getOcupacion());
        persona.setDomicilio(personaDTO.getDomicilio());
        persona.setEstado_civil(personaDTO.getEstado_civil());
        persona.setCelular(personaDTO.getCelular());
        persona.setCiudad(personaDTO.getCiudad());
        persona.setNivelIngles(personaDTO.getNivelIngles());
        persona.setFreelance(personaDTO.getFreelance());
        persona.setDni(personaDTO.getDni());
        persona.setCuit(personaDTO.getCuit());

        if (personaDTO.getResumen() != null && !personaDTO.getResumen().isEmpty()) {
            List<Resumenes> resumenes = personaDTO.getResumen().stream()
                    .map(resumenDTO -> {
                        Resumenes resumen = new Resumenes();
                        resumen.setDetalle(resumenDTO.getDetalle());
                        return resumen;
                    })
                    .collect(Collectors.toList());
            persona.setResumenes(resumenes);
        }

        // Guardar la persona en la base de datos
        return personaRepository.save(persona);
        
    }

    public PersonaDTO getOne(long id){
        Persona persona = personaRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Persona no encontrada con ID: " + id));

            PersonaDTO personaDTO = new PersonaDTO();
            personaDTO.setNombre(persona.getNombre());
            personaDTO.setApellido(persona.getApellido());
            personaDTO.setFecha_nacimiento(persona.getFecha_nacimiento());
            personaDTO.setNacionalidad(persona.getNacionalidad());
            personaDTO.setCorreo(persona.getCorreo());
            personaDTO.setOcupacion(persona.getOcupacion());
            personaDTO.setDomicilio(persona.getDomicilio());
            personaDTO.setEstado_civil(persona.getEstado_civil());
            personaDTO.setCelular(persona.getCelular());
            personaDTO.setCiudad(persona.getCiudad());
            personaDTO.setNivelIngles(persona.getNivelIngles());
            personaDTO.setFreelance(persona.getFreelance());
            personaDTO.setDni(persona.getDni());
            personaDTO.setCuit(persona.getCuit());
    
            List<Resumenes> resumenes = persona.getResumenes();
            List<ResumenesDTO> resumenesDTO = new ArrayList<>();
            for (Resumenes resumen : resumenes) {
                ResumenesDTO resumenDTO = new ResumenesDTO();
                resumenDTO.setId(resumen.getId_resumen());
                resumenDTO.setDetalle(resumen.getDetalle());
                resumenesDTO.add(resumenDTO);
            }
    
            personaDTO.setResumen(resumenesDTO);
    
            return personaDTO;
    }

    public boolean existsById(Long id){
        return personaRepository.existsById(id);
    }

    @Override
    public PersonaDTO editarPersona(PersonaDTO personaDTO) {
        Long personaId = personaDTO.getId();
        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new NoSuchElementException("Persona no encontrada con ID: " + personaId));

        persona.setNombre(personaDTO.getNombre());
        persona.setApellido(personaDTO.getApellido());
        persona.setFecha_nacimiento(personaDTO.getFecha_nacimiento());
        persona.setNacionalidad(personaDTO.getNacionalidad());
        persona.setCorreo(personaDTO.getCorreo());
        persona.setOcupacion(personaDTO.getOcupacion());
        persona.setDomicilio(personaDTO.getDomicilio());
        persona.setEstado_civil(personaDTO.getEstado_civil());
        persona.setCelular(personaDTO.getCelular());
        persona.setCiudad(personaDTO.getCiudad());
        persona.setNivelIngles(personaDTO.getNivelIngles());
        persona.setFreelance(personaDTO.getFreelance());
        persona.setDni(personaDTO.getDni());
        persona.setCuit(personaDTO.getCuit());

        List<ResumenesDTO> resumenesDTO = personaDTO.getResumen();
        List<Resumenes> resumenes = new ArrayList<>();
        for (ResumenesDTO resumenDTO : resumenesDTO) {
            // Verificar si la resumen ya existe en la base de datos por su ID
            if (resumenDTO.getId() != null) {
                Resumenes resumen = resumenesRepository.findById(resumenDTO.getId())
                        .orElseThrow(() -> new NoSuchElementException("resumen no encontrada con ID: " + resumenDTO.getId()));
                // Actualizar los datos de la resumen con los del DTO
                resumen.setDetalle(resumenDTO.getDetalle());
                resumenes.add(resumen);
            } else {
                // Crear una nueva resumen y asignarle los datos del DTO
                Resumenes resumen = new Resumenes();
                // Asignar los datos de la resumen del DTO a la nueva resumen
                resumen.setDetalle(resumenDTO.getDetalle());
                resumenes.add(resumen);
            }
        }

        // Establecer la lista actualizada de resumens en la persona
        persona.setResumenes(resumenes);

        // Guardar los cambios en la base de datos
        persona = personaRepository.save(persona);

        // Devolver el DTO actualizado
        return personaDTO;
    }

    @Override
    public void eliminarPersona(Long id) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Persona no encontrada con ID: " + id));
        
        List<Resumenes> resumenes = persona.getResumenes();
        for (Resumenes resumen : resumenes) {
            resumenesRepository.deleteById(resumen.getId_resumen());
        }

        // Eliminar la persona
        personaRepository.deleteById(id);
    }

    @Override
    public List<PersonaDTO> verPersona() {
        List<Persona> personas = personaRepository.findAll();
        List<PersonaDTO> personaDTO = new ArrayList<>();

        for (Persona persona : personas) {
            PersonaDTO perDTO = new PersonaDTO();
            perDTO.setId(persona.getIdpersona());
            perDTO.setNombre(persona.getNombre());
            perDTO.setApellido(persona.getApellido());
            perDTO.setFecha_nacimiento(persona.getFecha_nacimiento());
            perDTO.setNacionalidad(persona.getNacionalidad());
            perDTO.setCorreo(persona.getCorreo());
            perDTO.setOcupacion(persona.getOcupacion());
            perDTO.setDomicilio(persona.getDomicilio());
            perDTO.setEstado_civil(persona.getEstado_civil());
            perDTO.setCelular(persona.getCelular());
            perDTO.setCiudad(persona.getCiudad());
            perDTO.setNivelIngles(persona.getNivelIngles());
            perDTO.setFreelance(persona.getFreelance());
            perDTO.setDni(persona.getDni());
            perDTO.setCuit(persona.getCuit());

            List<Resumenes> resumenes = persona.getResumenes();
            List<ResumenesDTO> resumenesDTO = new ArrayList<>();
            for (Resumenes resumen : resumenes) {
                ResumenesDTO resumenDTO = new ResumenesDTO();
                resumenDTO.setId(resumen.getId_resumen());
                resumenDTO.setDetalle(resumen.getDetalle());
                resumenesDTO.add(resumenDTO);
            }

            perDTO.setResumen(resumenesDTO);
            personaDTO.add(perDTO);
        }

        return personaDTO;
    }
    

}
