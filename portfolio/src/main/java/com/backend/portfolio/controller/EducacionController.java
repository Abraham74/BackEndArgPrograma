package com.backend.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.portfolio.models.Educacion;

import com.backend.portfolio.repository.EducacionRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {

    @Autowired
	private EducacionRepository repositorio;

    //Este metodo retorna todos los datos de mi educacion
	@GetMapping("/educacion")
	public List<Educacion> educacion(){

		return repositorio.findAll();
	}
}
