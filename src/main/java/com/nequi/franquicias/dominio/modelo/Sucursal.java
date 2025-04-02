package com.nequi.franquicias.dominio.modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Sucursal {
    private String nombre;
    private Long franquiciaId;
    private List<Producto> productos;

}
