package com.back.api.logica.dto;

import java.io.Serializable;

public class TipoProductoDto implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 4223446710890744085L;
    private Integer idTipoProducto;
    private String nombre;
    private Boolean activo;

    public TipoProductoDto() {
        super();
    }

    public TipoProductoDto(Integer idTipoProducto, String nombre, Boolean activo) {
        this.idTipoProducto = idTipoProducto;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Integer getIdTipoProducto() {
        return this.idTipoProducto;
    }

    public TipoProductoDto setIdTipoProducto(Integer idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
        return this;
    }

    public String getNombre() {
        return this.nombre;
    }

    public TipoProductoDto setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Boolean isActivo() {
        return this.activo;
    }

    public Boolean getActivo() {
        return this.activo;
    }

    public TipoProductoDto setActivo(Boolean activo) {
        this.activo = activo;
        return this;
    }

}
