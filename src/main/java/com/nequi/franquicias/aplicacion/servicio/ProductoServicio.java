package com.nequi.franquicias.aplicacion.servicio;

import com.nequi.franquicias.aplicacion.dto.ProductoDTO;
import com.nequi.franquicias.aplicacion.dto.ProductoSucursalDTO;
import com.nequi.franquicias.aplicacion.exceptions.ExcepcionRegistroNoEncontrado;
import com.nequi.franquicias.aplicacion.mapeador.ProductoMapeador;
import com.nequi.franquicias.aplicacion.puerto.entrada.ProductoServicioInterfaz;
import com.nequi.franquicias.dominio.modelo.ProductoConSucursal;
import com.nequi.franquicias.dominio.repositorio.ProductoRepositorio;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@Service
public class ProductoServicio implements ProductoServicioInterfaz {
    private final ProductoRepositorio productoRepositorio;

    public ProductoServicio(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    @Override
    public Mono<Long> crearProducto(ProductoDTO producto) {
        return productoRepositorio.guardar(ProductoMapeador.aDominio(producto));
    }

    @Override
    public Mono<Void> borrarProducto(Long id) {
        return productoRepositorio.borrar(id);
    }

    @Override
    public Mono<Long> modificarStock(Long id, int nuevoStock) {
      return productoRepositorio.obtenerPorId(id).switchIfEmpty(Mono.error(new ExcepcionRegistroNoEncontrado("Producto con id " + id + " no encontrado")))
                .flatMap(producto -> {
                    producto.setStock(nuevoStock);
                   return productoRepositorio.modificarStock(producto);
                });
    }

    @Override
    public Flux<ProductoSucursalDTO> obtenerProductosPorFranquicia(Long id) {
        return productoRepositorio.obtenerProductosPorFranquicia(id)
                .groupBy(ProductoConSucursal::getSucursalId)
                .flatMap(group -> group
                        .sort(Comparator.comparingInt(ProductoConSucursal::getStock).reversed())
                        .take(1)
                )
                .map(ProductoMapeador::aDTO);
    }

    @Override
    public Mono<Void> modificarNombre(Long id, String nombre) {
        return productoRepositorio.obtenerPorId(id).switchIfEmpty(Mono.error(new ExcepcionRegistroNoEncontrado("Producto con id " + id + " no encontrado")))
                .flatMap(producto -> productoRepositorio.modificarNombre(id,nombre)
                );
    }

}
