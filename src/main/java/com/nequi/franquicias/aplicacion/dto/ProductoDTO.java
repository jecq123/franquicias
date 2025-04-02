package com.nequi.franquicias.aplicacion.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDTO {
    private Long id;
    private String nombre;
    private int stock;
    private Long sucursalId;
}
