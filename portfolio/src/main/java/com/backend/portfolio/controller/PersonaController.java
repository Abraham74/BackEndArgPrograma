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

import com.backend.portfolio.models.Persona;
import com.backend.portfolio.service.PersonaService;


@RestController
@CrossOrigin(origins = "https://frontportfolio-916a5.web.app")
public class PersonaController {
    
    @Autowired
	private PersonaService servicio;

    //Este metodo retorna todos los datos de la persona
	@GetMapping("/persona")
	public List<Persona> verPersona(){

		return servicio.verPersona();
	}

	//Este metodo obtiene el detalle de una persona
	@GetMapping("/persona/detalle/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") Long id){
        if(!servicio.existsById(id))
            return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
        Persona persona = servicio.getOne(id).get();
        return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }

	//Este metodo crea una nueva persona
	@PostMapping("/persona/nueva")
	public void agregarPersona(@RequestBody Persona pers){

		servicio.crearPersona(pers);
	}

	//Este metodo modifica a una persona
	@PutMapping("/persona/modificar/{id}")
	public void modificarPersona(@PathVariable Long id,@RequestBody Persona pers){

		servicio.editarPersona(id, pers);
	}

	//Este metodo elimina una persona
	@DeleteMapping("/persona/eliminar/{id}")
	public void borrarPersona(@PathVariable Long id){

		servicio.eliminarPersona(id);
	}
}
