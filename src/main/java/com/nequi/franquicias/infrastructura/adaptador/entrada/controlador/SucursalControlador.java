package com.nequi.franquicias.infrastructura.adaptador.entrada.controlador;

import com.nequi.franquicias.aplicacion.dto.NombreDTO;
import com.nequi.franquicias.aplicacion.dto.SucursalDTO;
import com.nequi.franquicias.aplicacion.puerto.entrada.SucursalServicioInterfaz;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/sucursales")
public class SucursalControlador {
    private final SucursalServicioInterfaz sucursalServicioInterfaz;
    public SucursalControlador(SucursalServicioInterfaz sucursalServicioInterfaz){
        this.sucursalServicioInterfaz = sucursalServicioInterfaz;
    }
    @PostMapping
    public Mono<Long> crearSucursal(@RequestBody SucursalDTO sucursal){
       return sucursalServicioInterfaz.crearSucursal(sucursal);
    }
    @PutMapping("/nombre/{id}")
    public Mono<Void> modificarNombre(@PathVariable Long id, @RequestBody NombreDTO nombreDTO){
        return sucursalServicioInterfaz.modificarNombre(id,nombreDTO.getNombre());
    }
}
