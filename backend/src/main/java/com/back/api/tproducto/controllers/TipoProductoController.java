package com.back.api.tproducto.controllers;

import java.io.Serializable;
import java.util.List;

import com.back.api.general.RespuestaServicio;
import com.back.api.tproducto.dto.TipoProductoDto;
import com.back.api.tproducto.services.TipoProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tipo/producto")
public class TipoProductoController implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2952285141872656480L;
    
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
}
