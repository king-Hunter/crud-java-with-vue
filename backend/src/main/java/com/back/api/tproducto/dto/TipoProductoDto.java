package com.back.api.tproducto.dto;

import java.io.Serializable;

public class TipoProductoDto implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 6281854760303955369L;
  
    
    private long idTipoProducto;
    private String nombre;
    private Boolean activo;

    public TipoProductoDto() {
        super();
    }

    public TipoProductoDto(long idTipoProducto, String nombre, Boolean activo) {
        this.idTipoProducto = idTipoProducto;
        this.nombre = nombre;
        this.activo = activo;
    }

    public long getIdTipoProducto() {
        return this.idTipoProducto;
    }

    public TipoProductoDto setIdTipoProducto(long idTipoProducto) {
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