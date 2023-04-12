package com.backend.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backend.portfolio.DTO.PersonaDTO;
import com.backend.portfolio.models.Persona;
import com.backend.portfolio.service.PersonaService;


@RestController
@CrossOrigin(origins = "https://frontportfolio-916a5.web.app")
@RequestMapping("/v1")
public class PersonaController {
    
    @Autowired
	private PersonaService servicio;

    //Este metodo retorna todos los datos de la persona
	@GetMapping("/persona")
	public List<PersonaDTO> verPersona(){

		return servicio.verPersona();
	}

	//Este metodo obtiene el detalle de una persona
	@GetMapping("/persona/detalle/{id}")
    public ResponseEntity<PersonaDTO> getById(@PathVariable("id") Long id){
        if(!servicio.existsById(id))
            return new ResponseEntity<PersonaDTO>(HttpStatus.NOT_FOUND);
        PersonaDTO persona = servicio.getOne(id);
        return new ResponseEntity<PersonaDTO>(persona, HttpStatus.OK);
    }

	//Este metodo crea una nueva persona
	@PostMapping("/persona/nueva")
	public Persona agregarPersona(@RequestBody PersonaDTO pers){

		return servicio.crearPersona(pers);
	}

	//Este metodo modifica a una persona
	@PutMapping("/persona/modificar/{id}")
	public void modificarPersona(@RequestBody PersonaDTO pers){

		servicio.editarPersona(pers);
	}

	//Este metodo elimina una persona
	@DeleteMapping("/persona/eliminar/{id}")
	public void borrarPersona(@PathVariable Long id){

		servicio.eliminarPersona(id);
	}
}
