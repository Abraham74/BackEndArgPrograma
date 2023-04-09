package com.backend.portfolio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.portfolio.DTO.ExperienciaDTO;
import com.backend.portfolio.DTO.TareasDTO;
import com.backend.portfolio.models.Experiencias;
import com.backend.portfolio.models.Tareas;
import com.backend.portfolio.repository.ExperienciaRepository;
import com.backend.portfolio.repository.TareasRepository;

@Service
public class ExperienciaService implements IExperienciaService {

    @Autowired
    private ExperienciaRepository experienciaRepository;

    @Autowired
    private TareasRepository tareasRepository;

    @Override
    public Experiencias crearExperiencia(ExperienciaDTO experienciaDTO) {
        Experiencias experiencia = new Experiencias();
        experiencia.setTitulo(experienciaDTO.getTitulo());
        experiencia.setNombre(experienciaDTO.getNombre());
        experiencia.setInicio(experienciaDTO.getInicio());
        experiencia.setFin(experienciaDTO.getFin());

        if (experienciaDTO.getTareas() != null && !experienciaDTO.getTareas().isEmpty()) {
            List<Tareas> tareas = experienciaDTO.getTareas().stream()
                    .map(tareaDTO -> {
                        Tareas tarea = new Tareas();
                        tarea.setDetalle(tareaDTO.getDetalle());
                        return tarea;
                    })
                    .collect(Collectors.toList());
            experiencia.setTareas(tareas);
        }

        // Guardar la experiencia en la base de datos
        return experienciaRepository.save(experiencia);
    }

    public ExperienciaDTO getOne(long id){
        Experiencias experiencia = experienciaRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Experiencia no encontrada con ID: " + id));

            ExperienciaDTO experienciaDTO = new ExperienciaDTO();
            experienciaDTO.setId(experiencia.getId());
            experienciaDTO.setTitulo(experiencia.getTitulo());
            experienciaDTO.setNombre(experiencia.getNombre());
            experienciaDTO.setInicio(experiencia.getInicio());
            experienciaDTO.setFin(experiencia.getFin());
    
            List<Tareas> tareas = experiencia.getTareas();
            List<TareasDTO> tareasDTO = new ArrayList<>();
            for (Tareas tarea : tareas) {
                TareasDTO tareaDTO = new TareasDTO();
                tareaDTO.setId(tarea.getId_tarea());
                tareaDTO.setDetalle(tarea.getDetalle());
                tareasDTO.add(tareaDTO);
            }
    
            experienciaDTO.setTareas(tareasDTO);
    
            return experienciaDTO;
    }

    public boolean existsById(Long id){
        return experienciaRepository.existsById(id);
    }

    @Override
    public ExperienciaDTO editarExperiencia(ExperienciaDTO experienciaDTO) {
        Long experienciaId = experienciaDTO.getId();
        Experiencias experiencia = experienciaRepository.findById(experienciaId)
                .orElseThrow(() -> new NoSuchElementException("Experiencia no encontrada con ID: " + experienciaId));

        experiencia.setTitulo(experienciaDTO.getTitulo());
        experiencia.setNombre(experienciaDTO.getNombre());
        experiencia.setInicio(experienciaDTO.getInicio());
        experiencia.setFin(experienciaDTO.getFin());

        List<TareasDTO> tareasDTO = experienciaDTO.getTareas();
        List<Tareas> tareas = new ArrayList<>();
        for (TareasDTO tareaDTO : tareasDTO) {
            // Verificar si la tarea ya existe en la base de datos por su ID
            if (tareaDTO.getId() != null) {
                Tareas tarea = tareasRepository.findById(tareaDTO.getId())
                        .orElseThrow(() -> new NoSuchElementException("Tarea no encontrada con ID: " + tareaDTO.getId()));
                // Actualizar los datos de la tarea con los del DTO
                tarea.setDetalle(tareaDTO.getDetalle());
                tareas.add(tarea);
            } else {
                // Crear una nueva tarea y asignarle los datos del DTO
                Tareas tarea = new Tareas();
                // Asignar los datos de la tarea del DTO a la nueva tarea
                tarea.setDetalle(tareaDTO.getDetalle());
                tareas.add(tarea);
            }
        }

        // Establecer la lista actualizada de tareas en la experiencia
        experiencia.setTareas(tareas);

        // Guardar los cambios en la base de datos
        experiencia = experienciaRepository.save(experiencia);

        // Devolver el DTO actualizado
        return experienciaDTO;
    }

    @Override
    public void eliminarExperiencia(Long id) {
        Experiencias experiencia = experienciaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Experiencia no encontrada con ID: " + id));
        
        List<Tareas> tareas = experiencia.getTareas();
        for (Tareas tarea : tareas) {
            tareasRepository.deleteById(tarea.getId_tarea());
        }

        // Eliminar la experiencia
        experienciaRepository.deleteById(id);
    }

    @Override
    public List<ExperienciaDTO> verExperiencia() {
        List<Experiencias> experiencias = experienciaRepository.findAll();
        List<ExperienciaDTO> experienciasDTO = new ArrayList<>();

        for (Experiencias experiencia : experiencias) {
            ExperienciaDTO experienciaDTO = new ExperienciaDTO();
            experienciaDTO.setId(experiencia.getId());
            experienciaDTO.setTitulo(experiencia.getTitulo());
            experienciaDTO.setNombre(experiencia.getNombre());
            experienciaDTO.setInicio(experiencia.getInicio());
            experienciaDTO.setFin(experiencia.getFin());

            List<Tareas> tareas = experiencia.getTareas();
            List<TareasDTO> tareasDTO = new ArrayList<>();
            for (Tareas tarea : tareas) {
                TareasDTO tareaDTO = new TareasDTO();
                tareaDTO.setId(tarea.getId_tarea());
                tareaDTO.setDetalle(tarea.getDetalle());
                tareasDTO.add(tareaDTO);
            }

            experienciaDTO.setTareas(tareasDTO);
            experienciasDTO.add(experienciaDTO);
        }

        return experienciasDTO;
    }
}
