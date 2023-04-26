package com.backend.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backend.portfolio.models.Proyectos;

import com.backend.portfolio.service.ProyectosService;


@RestController
@CrossOrigin(origins = "https://frontportfolio-916a5.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/v1")
public class ProyectosController {

    @Autowired
	private ProyectosService servicio;

    //Este metodo retorna todos los datos de mis proyectos
	@GetMapping("/proyectos")
	public List<Proyectos> proyectos(){

		return servicio.verProyectos();
	}

	//Este metodo obtiene el detalle de un proyecto
	@GetMapping("/proyectos/detalle/{id}")
	public ResponseEntity<Proyectos> getById(@PathVariable("id") Long id){
		if(!servicio.existsById(id))
			return new ResponseEntity<Proyectos>(HttpStatus.NOT_FOUND);
		Proyectos proyectos = servicio.getOne(id).get();
		return new ResponseEntity<Proyectos>(proyectos, HttpStatus.OK);
	}
	

	//Este metodo crea un nuevo proyecto
	@PostMapping("/proyectos/nuevo")
	public void agregarProyecto(@RequestBody Proyectos proy){

		servicio.crearProyecto(proy);
	}

	//Este metodo modifica a un proyecto
	@PutMapping("/proyectos/modificar/{id}")
	public void modificarProyecto(@PathVariable Long id,@RequestBody Proyectos proy){

		servicio.editarProyecto(id, proy);
	}

	//Este metodo elimina un proyecto
	@DeleteMapping("/proyectos/eliminar/{id}")
	public void borrarProyecto(@PathVariable Long id){

		servicio.eliminarProyecto(id);
	}
}
