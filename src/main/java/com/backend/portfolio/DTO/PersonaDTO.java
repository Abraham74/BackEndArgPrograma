package com.backend.portfolio.DTO;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonaDTO {
    private Long id;

    private String nombre;
    private String apellido;
    private Date fecha_nacimiento;
    private String nacionalidad;
    private String correo;
    private String ocupacion;
    private String domicilio;
    private String estado_civil;
    private String celular;
    private String ciudad;
    private String nivelIngles;
    private String freelance;
    private int dni;
    private String cuit;

    private List<ResumenesDTO> resumen;
}
