package com.nequi.franquicias.infrastructura.adaptador.persistencia.repositorio.impl;

import com.nequi.franquicias.aplicacion.mapeador.FranquiciaMapeador;
import com.nequi.franquicias.dominio.modelo.Franquicia;
import com.nequi.franquicias.dominio.repositorio.FranquiciaRepositorio;
import com.nequi.franquicias.infrastructura.adaptador.persistencia.entidad.FranquiciaEntidad;
import com.nequi.franquicias.infrastructura.adaptador.persistencia.repositorio.FranquiciaRepositorioReactive;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class FranquiciaRepositorioImpl implements FranquiciaRepositorio {
    private final FranquiciaRepositorioReactive franquiciaRepositorioReactive;

    public FranquiciaRepositorioImpl(FranquiciaRepositorioReactive franquiciaRepositorioReactive) {
        this.franquiciaRepositorioReactive = franquiciaRepositorioReactive;
    }

    @Override
    public Mono<Long> guardar(Franquicia franquicia) {
        FranquiciaEntidad entidad = FranquiciaMapeador.aEntidad(franquicia);
        return franquiciaRepositorioReactive.save(entidad)
                .map(FranquiciaEntidad::getId)
                .defaultIfEmpty(0L);
    }

    @Override
    public Mono<Void> modificarNombre(Long id, String nombre) {
        return franquiciaRepositorioReactive.actualizarNombre(id,nombre);
    }

    @Override
    public Mono<Franquicia> obtenerPorId(Long id) {
        return franquiciaRepositorioReactive.findById(id)
                .map(FranquiciaMapeador::aDominio);
    }
}
