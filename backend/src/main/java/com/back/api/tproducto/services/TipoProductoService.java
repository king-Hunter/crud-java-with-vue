package com.back.api.tproducto.services;
import java.io.Serializable;
import java.util.List;
import javax.transaction.Transactional;
import com.back.api.models.TipoProductoModel;
import com.back.api.repository.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.api.tproducto.dto.TipoProductoDto;
import java.util.stream.Collectors;

@Service
@Transactional
public class TipoProductoService implements Serializable {

    
    /**
     *
     */
    private static final long serialVersionUID = -35188523617740855L;
    @Autowired
    private transient TipoProductoRepository tipoProductoRepository;

    public List<TipoProductoDto> obtenerProductos() {

        List<TipoProductoModel> lista = tipoProductoRepository.findAll();
        return lista.stream().map(tipoProductoModel ->
                new TipoProductoDto(tipoProductoModel.getIdTipoProducto(),tipoProductoModel.getTipoProducto(),tipoProductoModel.getRegistroActivo())
        ).collect(Collectors.toList());
    }
}
