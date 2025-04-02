package com.nequi.franquicias.infrastructura.adaptador.persistencia.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table("producto")
public class ProductoEntidad {
    @Id
    private Long id;
    private String nombre;
    @Column("cantidad_en_stock")
    private int stock;
    @Column("sucursal_id")
    private Long sucursalId;
}
