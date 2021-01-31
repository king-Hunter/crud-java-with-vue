package com.back.api.logica.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import com.back.api.helper.Helpers;
import com.back.api.models.ProductoModel;
import com.back.api.models.TipoProductoModel;
import com.back.api.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.api.logica.dto.ProductoDto;

@Service
@Transactional
public class ProductoService implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1683031301876483645L;
    @Autowired
    private transient ProductoRepository productoRepository;
    private transient TipoProductoService tipoProductoService;

    public List<ProductoDto> obtenerProductos() {

        List<ProductoModel> lista = productoRepository.findAll();
        List<ProductoDto> respuesta = new ArrayList<>();
        for (ProductoModel producto : lista) {
            respuesta.add(new ProductoDto(producto.getIdProducto(), producto.getNombre(),
                    producto.getTipoProductoModel().getIdTipoProducto(), producto.getRegistroActivo()));

        }

        return respuesta;
    }

    public Boolean guardarTipoProducto(ProductoDto productoDto) {
        ProductoModel producto = new ProductoModel();
        Optional<TipoProductoModel> tipoProducto = tipoProductoService.unaColumna(productoDto.getIdTipoProducto());
        if (productoRepository.existsById(productoDto.getIdProducto())) {
            producto = productoRepository.findById(productoDto.getIdProducto()).get();
        } else {
            producto.setFechaAlta(Helpers.obtenerFechaActual());
            producto.setUsuarioAlta((long) 1);
        }

        producto.setNombre(productoDto.getNombre());
        
        producto.setTipoProductoModel(tipoProducto.get());
        producto.setFechaModificacion(Helpers.obtenerFechaActual());
        producto.setUsuarioModificacion((long) 1);
        producto.setRegistroActivo(productoDto.isActivo());
        productoRepository.save(producto);
        return true;
    }

    public Boolean deleteRegistro(Integer id) {
        Optional<ProductoModel> datos = productoRepository.findById(id);
        if (!datos.isPresent()) {
            return false;
        }
        datos.get().setRegistroActivo(!datos.get().getRegistroActivo());
        datos.get().setFechaModificacion(Helpers.obtenerFechaActual());
        datos.get().setUsuarioModificacion((long) 1);
        productoRepository.save(datos.get());
        return true;

    }
    
}
