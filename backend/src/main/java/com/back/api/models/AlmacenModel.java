package com.back.api.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "m_almacen")
public class AlmacenModel extends GlobalModel implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 2406308368555264254L;
    
    @Id
    @Column
    private Integer idAlmacen;

    @Column
    private String nombreAlmacen;
    

    /**
     * @return Integer return the idAlmacen
     */
    public Integer getIdAlmacen() {
        return idAlmacen;
    }

    /**
     * @param idAlmacen the idAlmacen to set
     */
    public AlmacenModel setIdAlmacen(Integer idAlmacen) {
        this.idAlmacen = idAlmacen;
        return this;
    }

    /**
     * @return String return the nombreAlmacen
     */
    public String getNombreAlmacen() {
        return nombreAlmacen;
    }

    /**
     * @param nombreAlmacen the nombreAlmacen to set
     */
    public AlmacenModel setNombreAlmacen(String nombreAlmacen) {
        this.nombreAlmacen = nombreAlmacen;
        return this;
    }

}
