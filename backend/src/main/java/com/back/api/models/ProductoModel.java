package com.back.api.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "m_producto")
public class ProductoModel  extends GlobalModel implements Serializable{

    
    /**
     *
     */
    private static final long serialVersionUID = 8929496367981491674L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idProducto;

    @Column
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_producto")
    private TipoProductoModel tipoProductoModel;
    

    /**
     * @return Long return the idProducto
     */
    public Long getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public ProductoModel setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
        return this;
    }

    /**
     * @return String return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public ProductoModel setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    /**
     * @return TipoProductoModel return the tipoProductoModel
     */
    public TipoProductoModel getTipoProductoModel() {
        return tipoProductoModel;
    }

    /**
     * @param tipoProductoModel the tipoProductoModel to set
     */
    public ProductoModel setTipoProductoModel(TipoProductoModel tipoProductoModel) {
        this.tipoProductoModel = tipoProductoModel;
        return this;
    }

}
