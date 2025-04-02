package com.nequi.franquicias.aplicacion.puerto.entrada;

import com.nequi.franquicias.aplicacion.dto.FranquiciaDTO;
import reactor.core.publisher.Mono;

public interface FranquiciaServicioInterfaz {
    Mono<Long> crearFranquicia(FranquiciaDTO franquiciaDTO);
    Mono<Void> modificarNombre(Long id,String nombre);
}
