package com.nequi.franquicias.infrastructura.adaptador.persistencia.repositorio.impl;

import com.nequi.franquicias.aplicacion.mapeador.ProductoMapeador;
import com.nequi.franquicias.dominio.modelo.Producto;
import com.nequi.franquicias.dominio.modelo.ProductoConSucursal;
import com.nequi.franquicias.dominio.repositorio.ProductoRepositorio;
import com.nequi.franquicias.infrastructura.adaptador.persistencia.entidad.ProductoEntidad;
import com.nequi.franquicias.infrastructura.adaptador.persistencia.repositorio.ProductoRepositorioReactive;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ProductoRepositorioImpl implements ProductoRepositorio {
    private final ProductoRepositorioReactive productoRepositorioReactive;

    public ProductoRepositorioImpl(ProductoRepositorioReactive productoRepositorioReactive) {
        this.productoRepositorioReactive = productoRepositorioReactive;
    }

    @Override
    public Mono<Producto> obtenerPorId(Long id) {
        return productoRepositorioReactive.findById(id)
                .map(ProductoMapeador::aDominio);
    }

    @Override
    public Mono<Long> guardar(Producto producto) {
        ProductoEntidad entidad = ProductoMapeador.aEntidad(producto);
        return productoRepositorioReactive.save(entidad)
                .map(ProductoEntidad::getId)
                .defaultIfEmpty(0L);
    }

    @Override
    public Mono<Void> borrar(Long id) {
        return productoRepositorioReactive.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Producto con id " + id + " no encontrado")))
                .flatMap(productoRepositorioReactive::delete);
    }

    @Override
    public Mono<Long> modificarStock(Producto producto) {
        ProductoEntidad productoEntidad = ProductoMapeador.aEntidad(producto);
        return productoRepositorioReactive.save(productoEntidad).map(ProductoEntidad::getId)
                .defaultIfEmpty(0L);
    }

    @Override
    public Flux<ProductoConSucursal> obtenerProductosPorFranquicia(Long franquiciaId) {
       return productoRepositorioReactive.findByFranquiciaId(franquiciaId).map(ProductoMapeador::aDominio);
    }

    @Override
    public Mono<Void> modificarNombre(Long id, String nombre) {
        return productoRepositorioReactive.actualizarNombre(id,nombre);
    }
}
