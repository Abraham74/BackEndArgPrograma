package com.backend.portfolio.DTO;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExperienciaDTO {
    private Long id;

    private String titulo;
    private String nombre;
    private int inicio;
    private String fin;

    private List<TareasDTO> tareas;
}
