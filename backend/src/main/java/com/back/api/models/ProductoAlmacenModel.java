package com.back.api.models;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "r_producto_almacen")
public class ProductoAlmacenModel extends GlobalModel implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -4767011440111456825L;

    @Id
    @Column 
    private long idProductoAlmacen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private ProductoModel productoModel;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_almacen")
    private AlmacenModel almacenModel;
    

    /**
     * @return Integer return the idProductoAlmacen
     */
    public long getIdProductoAlmacen() {
        return idProductoAlmacen;
    }

    /**
     * @param idProductoAlmacen the idProductoAlmacen to set
     */
    public ProductoAlmacenModel setIdProductoAlmacen(Integer idProductoAlmacen) {
        this.idProductoAlmacen = idProductoAlmacen;
        return this;
    }

    /**
     * @return ProductoModel return the productoModel
     */
    public ProductoModel getProductoModel() {
        return productoModel;
    }

    /**
     * @param productoModel the productoModel to set
     */
    public ProductoAlmacenModel setProductoModel(ProductoModel productoModel) {
        this.productoModel = productoModel;
        return this;
    }

    /**
     * @return AlmacenModel return the almacenModel
     */
    public AlmacenModel getAlmacenModel() {
        return almacenModel;
    }

    /**
     * @param almacenModel the almacenModel to set
     */
    public ProductoAlmacenModel setAlmacenModel(AlmacenModel almacenModel) {
        this.almacenModel = almacenModel;
        return this;
    }

}
