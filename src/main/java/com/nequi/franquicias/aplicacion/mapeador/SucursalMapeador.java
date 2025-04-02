package com.nequi.franquicias.aplicacion.mapeador;

import com.nequi.franquicias.aplicacion.dto.SucursalDTO;
import com.nequi.franquicias.dominio.modelo.Sucursal;
import com.nequi.franquicias.infrastructura.adaptador.persistencia.entidad.SucursalEntidad;


public class SucursalMapeador {
    public static Sucursal aDominio(SucursalDTO sucursalDTO) {
        if (sucursalDTO == null) {
            return null;
        }
        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(sucursalDTO.getNombre());
        sucursal.setFranquiciaId(sucursalDTO.getFranquiciaId());
        return sucursal;
    }

    public static SucursalEntidad aEntidad(Sucursal sucursal) {
        if (sucursal == null) {
            return null;
        }
        SucursalEntidad sucursalEntidad = new SucursalEntidad();
        sucursalEntidad.setNombre(sucursal.getNombre());
        sucursalEntidad.setFranquiciaId(sucursal.getFranquiciaId());

        return sucursalEntidad;
    }

    public static Sucursal aDominio(SucursalEntidad sucursalEntidad) {
        if (sucursalEntidad == null) {
            return null;
        }
        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(sucursalEntidad.getNombre());
        sucursal.setFranquiciaId(sucursalEntidad.getFranquiciaId());
        return sucursal;
    }
}
