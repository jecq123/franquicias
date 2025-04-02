package com.nequi.franquicias.aplicacion.mapeador;

import com.nequi.franquicias.aplicacion.dto.ProductoDTO;
import com.nequi.franquicias.aplicacion.dto.ProductoSucursalDTO;
import com.nequi.franquicias.dominio.modelo.Producto;
import com.nequi.franquicias.dominio.modelo.ProductoConSucursal;
import com.nequi.franquicias.infrastructura.adaptador.persistencia.entidad.ProductoConSucursalEntidad;
import com.nequi.franquicias.infrastructura.adaptador.persistencia.entidad.ProductoEntidad;

public class ProductoMapeador {
    private ProductoMapeador(){

    }
    public static Producto aDominio(ProductoDTO productoDTO) {
        if (productoDTO == null) {
            return null;
        }
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setStock(productoDTO.getStock());
        producto.setSucursalId(productoDTO.getSucursalId());
        return producto;
    }

    public static ProductoDTO aDTO(Producto producto) {
        if (producto == null) {
            return null;
        }
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setStock(producto.getStock());
        productoDTO.setSucursalId(producto.getSucursalId());
        return productoDTO;
    }

    public static ProductoEntidad aEntidad(Producto producto) {
        if (producto == null) {
            return null;
        }
        ProductoEntidad productoEntidad = new ProductoEntidad();
        productoEntidad.setId(producto.getId());
        productoEntidad.setNombre(producto.getNombre());
        productoEntidad.setStock(producto.getStock());
        productoEntidad.setSucursalId(producto.getSucursalId());
        return productoEntidad;
    }

    public static Producto aDominio(ProductoEntidad productoEntidad) {
        if (productoEntidad == null) {
            return null;
        }
        Producto producto = new Producto();
        producto.setId(productoEntidad.getId());
        producto.setNombre(productoEntidad.getNombre());
        producto.setStock(productoEntidad.getStock());
        producto.setSucursalId(productoEntidad.getSucursalId());
        return producto;
    }

    public static ProductoConSucursal aDominio(ProductoConSucursalEntidad productoEntidad) {
        if (productoEntidad == null) {
            return null;
        }
        ProductoConSucursal producto = new ProductoConSucursal();
        producto.setId(productoEntidad.getId());
        producto.setNombre(productoEntidad.getNombre());
        producto.setStock(productoEntidad.getStock());
        producto.setSucursalId(productoEntidad.getSucursalId());
        producto.setSucursalNombre(productoEntidad.getSucursalNombre());
        return producto;
    }

    public static ProductoSucursalDTO aDTO(ProductoConSucursal producto) {
        if (producto == null) {
            return null;
        }
        ProductoSucursalDTO productoDTO = new ProductoSucursalDTO();
        productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setStock(producto.getStock());
        productoDTO.setNombreSucursal(producto.getSucursalNombre());
        return productoDTO;
    }
}
