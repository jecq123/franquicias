package com.nequi.franquicias.dominio.repositorio;

import com.nequi.franquicias.dominio.modelo.Sucursal;
import reactor.core.publisher.Mono;

public interface SucursalRepositorio {
    Mono<Long> guardar(Sucursal sucursal);
    Mono<Void> modificarNombre(Long id, String nombre);
    Mono<Sucursal> obtenerPorId(Long id);
}
