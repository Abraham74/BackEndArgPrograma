package com.backend.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.portfolio.models.Experiencia;

import com.backend.portfolio.service.ExperienciaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {
    
    @Autowired
	private ExperienciaService servicio;

    //Este metodo retorna todos los datos de mi experiencia
	@GetMapping("/experiencia")
	public List<Experiencia> experienciaExperiencial(){

		return servicio.verExperiencia();
	}
	//Este metodo crea un nuevo item de Experiencia
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/Experiencia/nueva")
	public void agregarExperiencia(@RequestBody Experiencia exp){

		servicio.crearExperiencia(exp);
	}

	//Este metodo modifica a un item de Experiencia
	@PutMapping("/Experiencia/modificar/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void modificarExperiencia(@PathVariable Long id,@RequestBody Experiencia exp){

		servicio.editarExperiencia(id, exp);
	}

	//Este metodo elimina un item de Experiencia
	@DeleteMapping("/Experiencia/eliminar/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void borrarExperiencia(@PathVariable Long id){

		servicio.eliminarExperiencia(id);
	}
}
