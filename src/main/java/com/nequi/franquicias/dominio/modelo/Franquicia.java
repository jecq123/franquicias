package com.nequi.franquicias.dominio.modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Franquicia {
    private String nombre;
    private List<Sucursal> sucursales;
}
