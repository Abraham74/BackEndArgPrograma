package com.backend.portfolio.models;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_proyecto")
    private Long id_proyecto;

    private String nombre;
    private String descripcion;
    private String github_Url;
    private String deploy_Url;
}
