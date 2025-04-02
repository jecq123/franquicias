package com.nequi.franquicias.aplicacion.puerto.entrada;

import com.nequi.franquicias.aplicacion.dto.SucursalDTO;
import reactor.core.publisher.Mono;

public interface SucursalServicioInterfaz {
    Mono<Long> crearSucursal(SucursalDTO sucursal);
    Mono<Void> modificarNombre(Long id,String nombre);
}
