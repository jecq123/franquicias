package com.nequi.franquicias.infrastructura.adaptador.entrada.controlador.controladorexcepcion;

import com.nequi.franquicias.aplicacion.exceptions.ExcepcionRegistroNoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class ControladorExcepcion {

    @ExceptionHandler(ExcepcionRegistroNoEncontrado.class)
    public Mono<ResponseEntity<String>> manejarExcepcionRegistroNoEncontrado(ExcepcionRegistroNoEncontrado ex) {
        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<String>> manejarExcepcionGeneral(Exception ex) {
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor"));
    }
}

