package com.backend.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backend.portfolio.DTO.ExperienciaDTO;

import com.backend.portfolio.service.ExperienciaService;

@RestController
@CrossOrigin(origins = "https://frontportfolio-916a5.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/v1")
public class ExperienciaController {
    
    @Autowired
	private ExperienciaService servicio;

    //Este metodo retorna todos los datos de mi experiencia
	@GetMapping("/experiencias")
	public List<ExperienciaDTO> obtenerExperiencias(){

		return servicio.verExperiencia();
	}

	//Este metodo obtiene el detalle de una Experiencia Profesional
	@GetMapping("/experiencias/detalle/{id}")
    public ResponseEntity<ExperienciaDTO> getById(@PathVariable("id") Long id){
        if(!servicio.existsById(id))
            return new ResponseEntity<ExperienciaDTO>(HttpStatus.NOT_FOUND);
        ExperienciaDTO experiencia = servicio.getOne(id);
        return new ResponseEntity<ExperienciaDTO>(experiencia, HttpStatus.OK);
    }

	//Este metodo crea un nuevo item de Experiencia
	@PostMapping("/experiencias/nueva")
	public void agregarExperiencia(@RequestBody ExperienciaDTO exp){

		servicio.crearExperiencia(exp);
	}

	//Este metodo modifica a un item de Experiencia
	@PutMapping("/experiencias/modificar/{id}")
	public void modificarExperiencia(@RequestBody ExperienciaDTO exp){

		servicio.editarExperiencia(exp);
	}

	//Este metodo elimina un item de Experiencia
	@DeleteMapping("/experiencias/eliminar/{id}")
	public void borrarExperiencia(@PathVariable Long id){

		servicio.eliminarExperiencia(id);
	}
}
