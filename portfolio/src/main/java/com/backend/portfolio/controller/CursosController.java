package com.backend.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.portfolio.models.Cursos;

import com.backend.portfolio.repository.CursosRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CursosController {
    
    @Autowired
	private CursosRepository repositorio;

    //Este metodo retorna todos los datos de mis cursos
	@GetMapping("/cursos")
	public List<Cursos> cursos(){

		return repositorio.findAll();
	}
}
