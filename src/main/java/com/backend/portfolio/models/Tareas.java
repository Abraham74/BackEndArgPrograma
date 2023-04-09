package com.backend.portfolio.models;


import javax.persistence.*;
import javax.persistence.Id;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tareas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_tarea")
    private Long id_tarea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_exp")
    private Experiencias experiencia;

    private String detalle;
}
