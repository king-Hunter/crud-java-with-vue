package com.back.api.logica.controllers;

import java.io.Serializable;
import java.util.List;

import com.back.api.general.RespuestaServicio;
import com.back.api.logica.dto.ProductoDto;
import com.back.api.logica.services.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/producto")
public class ProductoControlador implements Serializable {

    
    /**
     *
     */
    private static final long serialVersionUID = -6913878735513078394L;
    @Autowired
    private transient ProductoService productoService;

    @GetMapping("/obtener")
    public ResponseEntity<RespuestaServicio<List<ProductoDto>>> obtenerTipoProductosActivos() {
        final RespuestaServicio<List<ProductoDto>> respuesta = new RespuestaServicio<>();
        try {
            List<ProductoDto> lista = productoService.obtenerProductos();
            return respuesta.obtenerRespuesta(lista, "Datos de tipo de producto obtenidos correctamente");
        } catch (Exception e) {
            return respuesta.obtenerRespuestaError("Ocurrio un error al obtener los datos");
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<RespuestaServicio<Boolean>> guardarProducto(@RequestBody ProductoDto productoDto) {
        final RespuestaServicio<Boolean> respuesta = new RespuestaServicio<>();

        try {
            boolean res = productoService.guardarTipoProducto(productoDto);
            return respuesta.obtenerRespuesta(res, "Datos guardados correctamente");
        } catch (Exception e) {
            return respuesta.obtenerRespuestaError("Ocurrio un error al guardar los datos");
        }
    }
    
    @DeleteMapping("/eliminar")
    public ResponseEntity<RespuestaServicio<Boolean>> eliminarProducto(@RequestParam Integer idProducto){
        final RespuestaServicio<Boolean> respuesta = new RespuestaServicio<>();
        try {
            boolean res = productoService.deleteRegistro(idProducto);
            return respuesta.obtenerRespuesta(res, "Se desabilito correctamente");
        } catch (Exception e) {
            return respuesta.obtenerRespuestaError("Ocurrio un err al procesar la peticion");
        }
    }
}
