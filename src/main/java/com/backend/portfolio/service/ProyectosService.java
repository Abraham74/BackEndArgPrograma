package com.backend.portfolio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.portfolio.models.Proyectos;
import com.backend.portfolio.repository.ProyectosRepository;

@Service
public class ProyectosService implements IProyectosService{

    @Autowired
    private ProyectosRepository proyectosRepository;

    @Override
    public void crearProyecto(Proyectos proyecto) {
        proyectosRepository.save(proyecto);
    }

    public Optional<Proyectos> getOne(long id){
        return proyectosRepository.findById(id);
    }

    public boolean existsById(Long id){
        return proyectosRepository.existsById(id);
    }

    @Override
    public Proyectos editarProyecto(Long id, Proyectos proy) {
        Proyectos proyecto = proyectosRepository.findById(id).get();

        proyecto.setNombre(proy.getNombre() == null ? proyecto.getNombre() : proy.getNombre());
        proyecto.setDescripcion(proy.getDescripcion() == null ? proyecto.getDescripcion() : proy.getDescripcion());
        proyecto.setGithub_Url(proy.getGithub_Url() == null ? proyecto.getGithub_Url() : proy.getGithub_Url());
        proyecto.setDeploy_Url(proy.getDeploy_Url() == null ? proyecto.getDeploy_Url() : proy.getDeploy_Url());

        proyectosRepository.save(proyecto);

        return proyecto;
    }

    @Override
    public void eliminarProyecto(Long id) {
        proyectosRepository.deleteById(id);
    }

    @Override
    public List<Proyectos> verProyectos() {
        return this.proyectosRepository.findAll();
    }
}
