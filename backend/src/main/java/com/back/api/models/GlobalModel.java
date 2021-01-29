package com.back.api.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.ZonedDateTime;

@MappedSuperclass
public class GlobalModel implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = -3908339471947109549L;

    @Column(name = "fecha_alta")
    protected ZonedDateTime fechaAlta;

    @Column(name = "fecha_modificacion")
    protected ZonedDateTime fechaModificacion;

    @Column(name = "usuario_alta")
    protected Long usuarioAlta;

    @Column(name = "usuario_modificacion")
    protected Long usuarioModificacion;

    @Column(name = "registro_activo")
    protected Boolean registroActivo;

    public ZonedDateTime getFechaAlta() {
        return fechaAlta;
    }

    public GlobalModel setFechaAlta(ZonedDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
        return this;
    }

    public ZonedDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public GlobalModel setFechaModificacion(ZonedDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
        return this;
    }

    public Long getUsuarioAlta() {
        return usuarioAlta;
    }

    public GlobalModel setUsuarioAlta(Long usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
        return this;
    }

    public Long getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public GlobalModel setUsuarioModificacion(Long usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
        return this;
    }

    public Boolean getRegistroActivo() {
        return registroActivo;
    }

    public GlobalModel setRegistroActivo(Boolean registroActivo) {
        this.registroActivo = registroActivo;
        return this;
    }
}
