package com.nequi.franquicias.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private Long id;
    private String nombre;
    private int stock;
    private Long sucursalId;
}
