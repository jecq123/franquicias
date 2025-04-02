package com.nequi.franquicias.infrastructura.adaptador.persistencia.entidad;

import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;
@NoArgsConstructor
public class ProductoConSucursalEntidad extends ProductoEntidad {
    @Column("sucursal_nombre")
    private String sucursalNombre;

    public ProductoConSucursalEntidad(Long id, String nombre, int stock, Long sucursalId, String sucursalNombre) {
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
