package com.nequi.franquicias.aplicacion.exceptions;

public class ExcepcionRegistroNoEncontrado extends RuntimeException{
    public ExcepcionRegistroNoEncontrado(String mensaje){
        super(mensaje);
    }
}
