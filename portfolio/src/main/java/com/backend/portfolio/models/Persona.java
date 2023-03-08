package com.backend.portfolio.models;

import java.sql.Date;

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
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long idpersona;

    private String nombre;
    private String apellido;
    private Date fecha_nacimiento;
    private String nacionalidad;
    private String correo;
    private String sobre_mi;
    private String ocupacion;
    private String image_background;
    private String image_perfil;
    private String domicilio;
    private String estado_civil;
    private String sobre_mi_r1;
    private String sobre_mi_r2;
    private String celular;
    private String ciudad;
    private String grade;
    private String freelance;
    private int dni;
    private String cuit;
}



