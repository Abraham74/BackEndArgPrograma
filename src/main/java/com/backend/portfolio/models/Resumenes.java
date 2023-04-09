package com.backend.portfolio.models;

import javax.persistence.*;
import javax.persistence.Id;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "resumenes")
public class Resumenes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_resumen")
    private Long id_resumen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    private String detalle;
}

