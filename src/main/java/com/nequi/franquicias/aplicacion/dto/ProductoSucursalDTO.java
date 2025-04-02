package com.nequi.franquicias.aplicacion.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoSucursalDTO {
    private Long id;
    private String nombre;
    private int stock;
    private String nombreSucursal;
}
