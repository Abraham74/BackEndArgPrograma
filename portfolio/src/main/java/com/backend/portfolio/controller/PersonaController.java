package com.backend.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.portfolio.models.Persona;

import com.backend.portfolio.repository.PersonaRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    
    @Autowired
	private PersonaRepository repositorio;

    //Este metodo retorna todos los datos de la persona
	@GetMapping("/persona")
	public List<Persona> persona(){

		return repositorio.findAll();
	}
}
