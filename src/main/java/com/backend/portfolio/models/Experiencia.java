package com.backend.portfolio.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
