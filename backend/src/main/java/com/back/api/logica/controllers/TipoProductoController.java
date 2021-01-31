package com.back.api.logica.controllers;

import java.io.Serializable;
import java.util.List;

import com.back.api.general.RespuestaServicio;
import com.back.api.logica.dto.TipoProductoDto;
import com.back.api.logica.services.TipoProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tipo/producto")
public class TipoProductoController implements Serializable {

    
    
    /**
     *
     */
    private static final long serialVersionUID = 4306312784816451223L;
    @Autowired
    private transient TipoProductoService tipoProductoService;

    @GetMapping("/obtener")
    public ResponseEntity<RespuestaServicio<List<TipoProductoDto>>> obtenerTipoProductosActivos(){
        final RespuestaServicio<List<TipoProductoDto>> respuesta = new RespuestaServicio<>();
        try {
            List<TipoProductoDto> lista = tipoProductoService.obtenerProductos();            
            return respuesta.obtenerRespuesta(lista, "Datos de tipo de producto obtenidos correctamente");
        } catch (Exception e) {
            return respuesta.obtenerRespuestaError("Ocurrio un error al obtener los datos");
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<RespuestaServicio<Boolean>> guardarProducto(@RequestBody TipoProductoDto tipoProductoDto){
        final RespuestaServicio<Boolean> respuesta = new RespuestaServicio<>();
        try {
            boolean res = tipoProductoService.guardarTipoProducto(tipoProductoDto);
            return respuesta.obtenerRespuesta(res, "Datos guardados correctamente");
        } catch (Exception e) {
            return respuesta.obtenerRespuestaError("Ocurrio un error al guardar los datos");
        }
    }
    
    @DeleteMapping("/eliminar")
    public ResponseEntity<RespuestaServicio<Boolean>> eliminarProducto(@RequestParam Integer idTipoProducto){
        final RespuestaServicio<Boolean> respuesta = new RespuestaServicio<>();
        try {
            boolean res = tipoProductoService.deleteRegistro(idTipoProducto);
            return respuesta.obtenerRespuesta(res, "Se desabilito correctamente");
        } catch (Exception e) {
            return respuesta.obtenerRespuestaError("Ocurrio un err al procesar la peticion");
        }
    }
    
}
