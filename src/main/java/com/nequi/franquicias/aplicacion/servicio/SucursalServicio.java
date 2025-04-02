package com.nequi.franquicias.aplicacion.servicio;

import com.nequi.franquicias.aplicacion.dto.SucursalDTO;
import com.nequi.franquicias.aplicacion.exceptions.ExcepcionRegistroNoEncontrado;
import com.nequi.franquicias.aplicacion.mapeador.SucursalMapeador;
import com.nequi.franquicias.aplicacion.puerto.entrada.SucursalServicioInterfaz;
import com.nequi.franquicias.dominio.repositorio.SucursalRepositorio;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SucursalServicio implements SucursalServicioInterfaz {
    private final SucursalRepositorio sucursalRepositorio;

    public SucursalServicio(SucursalRepositorio sucursalRepositorio) {
        this.sucursalRepositorio = sucursalRepositorio;
    }

    @Override
    public Mono<Long> crearSucursal(SucursalDTO sucursalDto) {
        return sucursalRepositorio.guardar(SucursalMapeador.aDominio(sucursalDto));
    }

    @Override
    public Mono<Void> modificarNombre(Long id, String nombre) {
        return sucursalRepositorio.obtenerPorId(id).switchIfEmpty(Mono.error(new ExcepcionRegistroNoEncontrado("Sucursal con id " + id + " no encontrado")))
                .flatMap(producto -> sucursalRepositorio.modificarNombre(id,nombre)
                );
    }
}
