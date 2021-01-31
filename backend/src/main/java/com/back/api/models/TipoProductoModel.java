package com.back.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "c_tipo_producto")
public class TipoProductoModel extends GlobalModel implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 8240815125324712437L;

    @Id
    @Column
    private Integer idTipoProducto;

    @Column
    private String tipoProducto;

    /**
     * @return Integer return the idTipoProducto
     */
    public Integer getIdTipoProducto() {
        return idTipoProducto;
    }

    /**
     * @param idTipoProducto the idTipoProducto to set
     */
    public TipoProductoModel setIdTipoProducto(Integer idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
        return this;
    }

    /**
     * @return String return the tipoProducto
     */
    public String getTipoProducto() {
        return tipoProducto;
    }

    /**
     * @param tipoProducto the tipoProducto to set
     */
    public TipoProductoModel setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
        return this;
    }

}
