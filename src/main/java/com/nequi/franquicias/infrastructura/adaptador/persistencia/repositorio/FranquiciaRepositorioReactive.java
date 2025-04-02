package com.nequi.franquicias.infrastructura.adaptador.persistencia.repositorio;

import com.nequi.franquicias.infrastructura.adaptador.persistencia.entidad.FranquiciaEntidad;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface FranquiciaRepositorioReactive extends ReactiveCrudRepository<FranquiciaEntidad, Long> {
    @Modifying
    @Query("UPDATE franquicia SET nombre = :nuevoNombre WHERE id = :id")
    Mono<Void> actualizarNombre(@Param("id") Long id, @Param("nuevoNombre") String nuevoNombre);
}
