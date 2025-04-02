package com.nequi.franquicias.aplicacion.servicio;

import com.nequi.franquicias.aplicacion.dto.SucursalDTO;
import com.nequi.franquicias.aplicacion.exceptions.ExcepcionRegistroNoEncontrado;
import com.nequi.franquicias.aplicacion.mapeador.ProductoMapeador;
import com.nequi.franquicias.aplicacion.mapeador.SucursalMapeador;
import com.nequi.franquicias.aplicacion.puerto.entrada.SucursalServicioInterfaz;
import com.nequi.franquicias.dominio.repositorio.FranquiciaRepositorio;
import com.nequi.franquicias.dominio.repositorio.SucursalRepositorio;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SucursalServicio implements SucursalServicioInterfaz {
    private final SucursalRepositorio sucursalRepositorio;
    private final FranquiciaRepositorio franquiciaRepositorio;
    public SucursalServicio(SucursalRepositorio sucursalRepositorio, FranquiciaRepositorio franquiciaRepositorio) {
        this.sucursalRepositorio = sucursalRepositorio;
        this.franquiciaRepositorio = franquiciaRepositorio;
    }

    @Override
    public Mono<Long> crearSucursal(SucursalDTO sucursalDto) {
        return franquiciaRepositorio.obtenerPorId(sucursalDto.getFranquiciaId()).switchIfEmpty(Mono.error(new ExcepcionRegistroNoEncontrado("Franquisia con id " + sucursalDto.getFranquiciaId() + " no encontrado")))
                .flatMap(sucursal ->
                        sucursalRepositorio.guardar(SucursalMapeador.aDominio(sucursalDto))
                );
    }

    @Override
    public Mono<Void> modificarNombre(Long id, String nombre) {
        return sucursalRepositorio.obtenerPorId(id).switchIfEmpty(Mono.error(new ExcepcionRegistroNoEncontrado("Sucursal con id " + id + " no encontrado")))
                .flatMap(producto -> sucursalRepositorio.modificarNombre(id,nombre)
                );
    }
}
