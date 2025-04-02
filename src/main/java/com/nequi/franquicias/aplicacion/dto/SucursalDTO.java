package com.nequi.franquicias.aplicacion.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SucursalDTO {
    private Long id;
    private String nombre;
    private Long franquiciaId;
}
