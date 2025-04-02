package com.nequi.franquicias.dominio.repositorio;

import com.nequi.franquicias.dominio.modelo.Producto;
import com.nequi.franquicias.dominio.modelo.ProductoConSucursal;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoRepositorio {
    Mono<Producto> obtenerPorId(Long id);
    Mono<Long> guardar(Producto producto);
    Mono<Void> borrar(Long id);
    Mono<Long> modificarStock(Producto producto);

    Flux<ProductoConSucursal> obtenerProductosPorFranquicia(Long franquiciaId);
    Mono<Void> modificarNombre(Long id, String nombre);
}
