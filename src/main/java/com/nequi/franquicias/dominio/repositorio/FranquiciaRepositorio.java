package com.nequi.franquicias.dominio.repositorio;

import com.nequi.franquicias.dominio.modelo.Franquicia;
import reactor.core.publisher.Mono;

public interface FranquiciaRepositorio {
    Mono<Long> guardar(Franquicia franquicia);
    Mono<Void> modificarNombre(Long id, String nombre);
    Mono<Franquicia> obtenerPorId(Long id);
}
