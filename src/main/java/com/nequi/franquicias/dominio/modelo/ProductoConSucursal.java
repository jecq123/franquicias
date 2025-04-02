package com.nequi.franquicias.dominio.modelo;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductoConSucursal extends Producto{
    private String sucursalNombre;

    public ProductoConSucursal(Long id, String nombre, int stock, Long sucursalId, String sucursalNombre) {
        super(id, nombre, stock, sucursalId);
        this.sucursalNombre = sucursalNombre;
    }

    public String getSucursalNombre() {
        return sucursalNombre;
    }

    public void setSucursalNombre(String sucursalNombre) {
        this.sucursalNombre = sucursalNombre;
    }
}
