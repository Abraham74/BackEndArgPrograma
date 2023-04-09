package com.backend.portfolio.models;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_cursos")
    private Long id_cursos;

    private String nombre;
    private String fecha;
    private String autor;
}
