package com.nequi.franquicias.infrastructura.adaptador.persistencia.repositorio;

import com.nequi.franquicias.infrastructura.adaptador.persistencia.entidad.ProductoConSucursalEntidad;
import com.nequi.franquicias.infrastructura.adaptador.persistencia.entidad.ProductoEntidad;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoRepositorioReactive extends ReactiveCrudRepository<ProductoEntidad, Long> {
    @Query("SELECT p.id, p.nombre, p.cantidad_en_stock, p.sucursal_id, s.nombre AS sucursal_nombre " +
            "FROM producto p " +
            "JOIN sucursal s ON p.sucursal_id = s.id " +
            "WHERE s.franquicia_id = :franquiciaId")
    Flux<ProductoConSucursalEntidad> findByFranquiciaId(@Param("franquiciaId") Long franquiciaId);

    @Modifying
    @Query("UPDATE producto SET nombre = :nuevoNombre WHERE id = :id")
    Mono<Void> actualizarNombre(@Param("id") Long id, @Param("nuevoNombre") String nuevoNombre);


}
