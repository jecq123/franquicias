package com.nequi.franquicias.aplicacion.servicio;

import com.nequi.franquicias.aplicacion.dto.FranquiciaDTO;
import com.nequi.franquicias.aplicacion.exceptions.ExcepcionRegistroNoEncontrado;
import com.nequi.franquicias.aplicacion.mapeador.FranquiciaMapeador;
import com.nequi.franquicias.aplicacion.puerto.entrada.FranquiciaServicioInterfaz;
import com.nequi.franquicias.dominio.repositorio.FranquiciaRepositorio;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FranquiciaServicio implements FranquiciaServicioInterfaz {
    private final FranquiciaRepositorio franquiciaRepositorio;

    public FranquiciaServicio(FranquiciaRepositorio franquiciaRepositorio) {
        this.franquiciaRepositorio = franquiciaRepositorio;
    }

    @Override
    public Mono<Long> crearFranquicia(FranquiciaDTO franquiciaDTO) {
        return franquiciaRepositorio.guardar(FranquiciaMapeador.aDominio(franquiciaDTO));
    }

    @Override
    public Mono<Void> modificarNombre(Long id, String nombre) {
        return franquiciaRepositorio.obtenerPorId(id).switchIfEmpty(Mono.error(new ExcepcionRegistroNoEncontrado("Franquicia con id " + id + " no encontrado")))
                .flatMap(producto -> franquiciaRepositorio.modificarNombre(id,nombre)
                );
    }
}
