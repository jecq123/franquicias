package com.nequi.franquicias.infrastructura.adaptador.entrada.controlador;

import com.nequi.franquicias.aplicacion.dto.FranquiciaDTO;
import com.nequi.franquicias.aplicacion.dto.NombreDTO;
import com.nequi.franquicias.aplicacion.puerto.entrada.FranquiciaServicioInterfaz;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/franquicias")
public class FranquiciaControlador {
    public final FranquiciaServicioInterfaz franquiciaServicioInterfaz;
    public FranquiciaControlador(FranquiciaServicioInterfaz franquiciaServicioInterfaz){
        this.franquiciaServicioInterfaz = franquiciaServicioInterfaz;
    }
    @PostMapping
    public Mono<Long> crearFranquicia(@RequestBody FranquiciaDTO franquicia){
        return franquiciaServicioInterfaz.crearFranquicia(franquicia);
    }

    @PutMapping("/nombre/{id}")
    public Mono<Void> modificarNombre(@PathVariable Long id, @RequestBody NombreDTO nombreDTO){
        return franquiciaServicioInterfaz.modificarNombre(id,nombreDTO.getNombre());
    }
}
