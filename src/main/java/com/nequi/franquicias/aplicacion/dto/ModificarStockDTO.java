package com.nequi.franquicias.aplicacion.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModificarStockDTO {
    private Long productoId;
    private int nuevoStock;
}
