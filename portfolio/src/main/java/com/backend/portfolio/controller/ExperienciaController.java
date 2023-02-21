package com.backend.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.portfolio.models.Experiencia;

import com.backend.portfolio.repository.ExperienciaRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {
    
    @Autowired
	private ExperienciaRepository repositorio;

    //Este metodo retorna todos los datos de mis cursos
	@GetMapping("/experiencia")
	public List<Experiencia> experienciaPersonal(){

		return repositorio.findAll();
	}
}
