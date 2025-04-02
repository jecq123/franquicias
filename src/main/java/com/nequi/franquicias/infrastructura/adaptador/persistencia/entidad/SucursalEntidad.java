package com.nequi.franquicias.infrastructura.adaptador.persistencia.entidad;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("sucursal")
public class SucursalEntidad {
    @Id
    private Long id;
    private String nombre;
    @Column("franquicia_id")
    private Long franquiciaId;
}
