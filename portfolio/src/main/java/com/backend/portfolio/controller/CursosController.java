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

import com.backend.portfolio.models.Cursos;

import com.backend.portfolio.service.CursosService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CursosController {
    
    @Autowired
	private CursosService servicio;

    //Este metodo retorna todos los datos de mis cursos
	@GetMapping("/cursos")
	public List<Cursos> cursos(){

		return servicio.verCursos();
	}

	//Este metodo crea un nuevo curso
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/cursos/nuevo")
	public void agregarCurso(@RequestBody Cursos cur){

		servicio.crearCurso(cur);
	}

	//Este metodo modifica un curso
	@PutMapping("/cursos/modificar/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void modificarPersona(@PathVariable Long id,@RequestBody Cursos cur){

		servicio.editarCurso(id, cur);
	}

	//Este metodo elimina un curso
	@DeleteMapping("/cursos/eliminar/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void borrarPersona(@PathVariable Long id){

		servicio.eliminarCurso(id);
	}

	
}
