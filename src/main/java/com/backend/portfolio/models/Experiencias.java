package com.backend.portfolio.models;

import java.util.List;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "experiencia")
public class Experiencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_exp")
    private Long id;

    private String titulo;
    private String nombre;
    private int inicio;
    private String fin;

    @OneToMany(mappedBy = "experiencia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tareas> tareas;
}
