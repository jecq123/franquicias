package com.nequi.franquicias.infrastructura.adaptador.entrada.controlador;
import com.nequi.franquicias.aplicacion.dto.ModificarStockDTO;
import com.nequi.franquicias.aplicacion.dto.NombreDTO;
import com.nequi.franquicias.aplicacion.dto.ProductoDTO;
import com.nequi.franquicias.aplicacion.dto.ProductoSucursalDTO;
import com.nequi.franquicias.aplicacion.puerto.entrada.ProductoServicioInterfaz;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/productos")
public class ProductoControlador {
    private final ProductoServicioInterfaz productoServicioInterfaz;

    public ProductoControlador(ProductoServicioInterfaz productoServicioInterfaz){
        this.productoServicioInterfaz = productoServicioInterfaz;
    }
    @PostMapping
    public Mono<Long> crearProducto(@RequestBody ProductoDTO producto){
       return productoServicioInterfaz.crearProducto(producto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> borrarProducto(@PathVariable Long id){
        return productoServicioInterfaz.borrarProducto(id);
    }

    @PutMapping("/modificar-stock")
    public Mono<Long> incrementoStock(@RequestBody ModificarStockDTO modificarStockDTO){
        return productoServicioInterfaz.modificarStock(modificarStockDTO.getProductoId(), modificarStockDTO.getNuevoStock());
    }

    @GetMapping("/mayor-stock/franquicia/{id}")
    public Flux<ProductoSucursalDTO> traerProductoMayorStock(@PathVariable Long id){
        return productoServicioInterfaz.obtenerProductosPorFranquicia(id);
    }

    @PutMapping("/nombre/{id}")
    public Mono<Void> modificarNombre(@PathVariable Long id, @RequestBody NombreDTO nombreDTO){
        return productoServicioInterfaz.modificarNombre(id,nombreDTO.getNombre());
    }
}
