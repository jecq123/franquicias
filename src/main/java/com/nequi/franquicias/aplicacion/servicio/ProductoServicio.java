package com.nequi.franquicias.aplicacion.servicio;

import com.nequi.franquicias.aplicacion.dto.ProductoDTO;
import com.nequi.franquicias.aplicacion.dto.ProductoSucursalDTO;
import com.nequi.franquicias.aplicacion.exceptions.ExcepcionRegistroNoEncontrado;
import com.nequi.franquicias.aplicacion.mapeador.ProductoMapeador;
import com.nequi.franquicias.aplicacion.puerto.entrada.ProductoServicioInterfaz;
import com.nequi.franquicias.dominio.modelo.ProductoConSucursal;
import com.nequi.franquicias.dominio.repositorio.ProductoRepositorio;
import com.nequi.franquicias.dominio.repositorio.SucursalRepositorio;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@Service
public class ProductoServicio implements ProductoServicioInterfaz {
    private final ProductoRepositorio productoRepositorio;
    private final SucursalRepositorio sucursalRepositorio;

    public ProductoServicio(ProductoRepositorio productoRepositorio, SucursalRepositorio sucursalRepositorio) {
        this.productoRepositorio = productoRepositorio;
        this.sucursalRepositorio = sucursalRepositorio;
    }

    @Override
    public Mono<Long> crearProducto(ProductoDTO producto) {
        return sucursalRepositorio.obtenerPorId(producto.getSucursalId()).switchIfEmpty(Mono.error(new ExcepcionRegistroNoEncontrado("Sucursal con id " + producto.getSucursalId() + " no encontrado")))
                .flatMap(sucursal ->
                     productoRepositorio.modificarStock(ProductoMapeador.aDominio(producto))
                );
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
