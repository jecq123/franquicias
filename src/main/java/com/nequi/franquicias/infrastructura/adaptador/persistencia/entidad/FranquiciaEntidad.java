package com.nequi.franquicias.infrastructura.adaptador.persistencia.entidad;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Getter
@Setter
@Table("franquicia")
public class FranquiciaEntidad {
    @Id
    private Long id;
    private String nombre;


}
