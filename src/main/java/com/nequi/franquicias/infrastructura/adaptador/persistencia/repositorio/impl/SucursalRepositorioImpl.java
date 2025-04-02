package com.nequi.franquicias.infrastructura.adaptador.persistencia.repositorio.impl;


import com.nequi.franquicias.aplicacion.mapeador.SucursalMapeador;
import com.nequi.franquicias.dominio.modelo.Sucursal;
import com.nequi.franquicias.dominio.repositorio.SucursalRepositorio;
import com.nequi.franquicias.infrastructura.adaptador.persistencia.entidad.SucursalEntidad;
import com.nequi.franquicias.infrastructura.adaptador.persistencia.repositorio.SucursalRepositorioReactive;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class SucursalRepositorioImpl implements SucursalRepositorio {
    private final SucursalRepositorioReactive sucursalRepositorioReactive;

    public SucursalRepositorioImpl(SucursalRepositorioReactive sucursalRepositorioReactive) {
        this.sucursalRepositorioReactive = sucursalRepositorioReactive;
    }

    @Override
    public Mono<Long> guardar(Sucursal sucursal) {
        SucursalEntidad entidad = SucursalMapeador.aEntidad(sucursal);
        return sucursalRepositorioReactive.save(entidad)
                .map(SucursalEntidad::getId)
                .defaultIfEmpty(0L);
    }

    @Override
    public Mono<Void> modificarNombre(Long id, String nombre) {
        return sucursalRepositorioReactive.actualizarNombre(id,nombre);
    }

    @Override
    public Mono<Sucursal> obtenerPorId(Long id) {
        return sucursalRepositorioReactive.findById(id)
                .map(SucursalMapeador::aDominio);
    }
}
