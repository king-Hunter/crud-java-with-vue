package com.back.api.logica.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import com.back.api.helper.Helpers;
import com.back.api.models.TipoProductoModel;
import com.back.api.repository.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.api.logica.dto.TipoProductoDto;
import java.util.stream.Collectors;

@Service
@Transactional
public class TipoProductoService implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2314140315779049974L;
    @Autowired
    private transient TipoProductoRepository tipoProductoRepository;

    public List<TipoProductoDto> obtenerProductos() {

        List<TipoProductoModel> lista = tipoProductoRepository.findAll();
        return lista.stream()
                .map(tipoProductoModel -> new TipoProductoDto(tipoProductoModel.getIdTipoProducto(),
                        tipoProductoModel.getTipoProducto(), tipoProductoModel.getRegistroActivo()))
                .collect(Collectors.toList());
    }

    public Boolean guardarTipoProducto(TipoProductoDto tipoProductoDto) {

        TipoProductoModel tipoProductoModel = new TipoProductoModel();
        if (tipoProductoRepository.existsById(tipoProductoDto.getIdTipoProducto()))  {
            tipoProductoModel = tipoProductoRepository.findById(tipoProductoDto.getIdTipoProducto()).get();
        } else {
                tipoProductoModel.setIdTipoProducto(tipoProductoDto.getIdTipoProducto());
                tipoProductoModel.setFechaAlta(Helpers.obtenerFechaActual());
                tipoProductoModel.setUsuarioAlta((long) 1);
            
        }
        tipoProductoModel.setTipoProducto(tipoProductoDto.getNombre());
        tipoProductoModel.setFechaModificacion(Helpers.obtenerFechaActual());
        tipoProductoModel.setUsuarioModificacion((long) 1);
        tipoProductoModel.setRegistroActivo(tipoProductoDto.getActivo());
        tipoProductoRepository.save(tipoProductoModel);

        return true;
    }

    public Boolean deleteRegistro(Integer id){
        Optional<TipoProductoModel> datos = tipoProductoRepository.findById(id);

        if (!datos.isPresent()){ return  false;}

        datos.get().setRegistroActivo(!datos.get().getRegistroActivo());
        datos.get().setFechaModificacion(Helpers.obtenerFechaActual());
        datos.get().setUsuarioModificacion((long) 1);

        tipoProductoRepository.save(datos.get());

        return true;
    }
    
}
