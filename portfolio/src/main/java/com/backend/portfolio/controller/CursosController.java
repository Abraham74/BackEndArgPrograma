package com.backend.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	//Este metodo obtiene el detalle de un cursos
	@GetMapping("/cursos/detalle/{id}")
	public ResponseEntity<Cursos> getById(@PathVariable("id") Long id){
		if(!servicio.existsById(id))
			return new ResponseEntity<Cursos>(HttpStatus.NOT_FOUND);
			Cursos cursos = servicio.getOne(id).get();
		return new ResponseEntity<Cursos>(cursos, HttpStatus.OK);
	}
	

	//Este metodo crea un nuevo curso
	@PostMapping("/cursos/nuevo")
	public void agregarCurso(@RequestBody Cursos cur){

		servicio.crearCurso(cur);
	}

	//Este metodo modifica un curso
	@PutMapping("/cursos/modificar/{id}")
	public void modificarcursos(@PathVariable Long id,@RequestBody Cursos cur){

		servicio.editarCurso(id, cur);
	}

	//Este metodo elimina un curso
	@DeleteMapping("/cursos/eliminar/{id}")
	public void borrarcursos(@PathVariable Long id){

		servicio.eliminarCurso(id);
	}

	
}
