package com.back.api.logica.dto;

import java.io.Serializable;


public class ProductoDto implements Serializable{

	/**
     *
     */
    private static final long serialVersionUID = 8919787064615967925L;
    private Integer idProducto;
    private String nombre;
    private Integer idTipoProducto;
    private Boolean activo;

    public ProductoDto() {
        super();
    }

    public ProductoDto(Integer idProducto, String nombre, Integer idTipoProducto, Boolean activo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.idTipoProducto = idTipoProducto;
        this.activo = activo;
    }

    /**
     * @return Integer return the idProducto
     */
    public Integer getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public ProductoDto setIdProducto(Integer idProducto) {
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
    public ProductoDto setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    /**
     * @return Integer return the idTipoProducto
     */
    public Integer getIdTipoProducto() {
        return idTipoProducto;
    }

    /**
     * @param idTipoProducto the idTipoProducto to set
     */
    public ProductoDto setIdTipoProducto(Integer idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
        return this;
    }

    /**
     * @return Boolean return the activo
     */
    public Boolean isActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public ProductoDto setActivo(Boolean activo) {
        this.activo = activo;
        return this;
    }

}
