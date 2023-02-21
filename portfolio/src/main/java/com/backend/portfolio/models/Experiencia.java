package com.backend.portfolio.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_exp")
    private Long id_exp;

    private String titulo;
    private String nombre;
    private int inicio;
    private String fin;
    private String tarea1;
    private String tarea2;
    private String tarea3;
    private String tarea4;
}
