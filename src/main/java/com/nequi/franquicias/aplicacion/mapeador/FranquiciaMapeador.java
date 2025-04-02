package com.nequi.franquicias.aplicacion.mapeador;

import com.nequi.franquicias.aplicacion.dto.FranquiciaDTO;
import com.nequi.franquicias.dominio.modelo.Franquicia;
import com.nequi.franquicias.infrastructura.adaptador.persistencia.entidad.FranquiciaEntidad;

public class FranquiciaMapeador {
    private FranquiciaMapeador(){

    }
    public static Franquicia aDominio(FranquiciaDTO franquiciaDTO) {
        if (franquiciaDTO == null) {
            return null;
        }
        Franquicia franquicia = new Franquicia();
        franquicia.setNombre(franquiciaDTO.getNombre());
        return franquicia;
    }


    public static FranquiciaEntidad aEntidad(Franquicia franquicia) {
        if (franquicia == null) {
            return null;
        }
        FranquiciaEntidad franquiciaEntidad = new FranquiciaEntidad();
        franquiciaEntidad.setNombre(franquicia.getNombre());
        return franquiciaEntidad;
    }

    public static Franquicia aDominio(FranquiciaEntidad franquiciaEntidad) {
        if (franquiciaEntidad == null) {
            return null;
        }
        Franquicia franquicia = new Franquicia();
        franquicia.setNombre(franquiciaEntidad.getNombre());
        return franquicia;
    }


}
