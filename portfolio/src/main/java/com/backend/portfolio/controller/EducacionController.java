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

import com.backend.portfolio.models.Educacion;

import com.backend.portfolio.service.EducacionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {

    @Autowired
	private EducacionService servicio;

    //Este metodo retorna todos los datos de mi educacion
	@GetMapping("/educacion")
	public List<Educacion> educacion(){

		return servicio.verEducacion();
	}

	//Este metodo obtiene el detalle de una Educacion
	@GetMapping("/educacion/detalle/{id}")
	public ResponseEntity<Educacion> getById(@PathVariable("id") Long id){
		if(!servicio.existsById(id))
			return new ResponseEntity<Educacion>(HttpStatus.NOT_FOUND);
		Educacion educacion = servicio.getOne(id).get();
		return new ResponseEntity<Educacion>(educacion, HttpStatus.OK);
	}
	

	//Este metodo crea un nuevo item de educacion
	@PostMapping("/educacion/nuevo")
	public void agregarEducacion(@RequestBody Educacion edu){

		servicio.crearEducacion(edu);
	}

	//Este metodo modifica a un item de Educacion
	@PutMapping("/educacion/modificar/{id}")
	public void modificarEducacion(@PathVariable Long id,@RequestBody Educacion edu){

		servicio.editarEducacion(id, edu);
	}

	//Este metodo elimina un item de Educacion
	@DeleteMapping("/educacion/eliminar/{id}")
	public void borrarEducacion(@PathVariable Long id){

		servicio.eliminarEducacion(id);
	}
}
