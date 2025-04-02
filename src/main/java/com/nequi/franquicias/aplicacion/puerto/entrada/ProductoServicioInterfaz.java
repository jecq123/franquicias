package com.nequi.franquicias.aplicacion.puerto.entrada;

import com.nequi.franquicias.aplicacion.dto.ProductoDTO;
import com.nequi.franquicias.aplicacion.dto.ProductoSucursalDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoServicioInterfaz {
    Mono<Long> crearProducto(ProductoDTO producto);
    Mono<Void> borrarProducto(Long id);
    Mono<Long> modificarStock(Long id,int nuevoStock);
    Flux<ProductoSucursalDTO> obtenerProductosPorFranquicia(Long id);
    Mono<Void> modificarNombre(Long id,String nombre);
}
