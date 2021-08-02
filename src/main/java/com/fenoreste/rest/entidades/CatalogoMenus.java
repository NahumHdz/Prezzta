/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author wilmer
 */
@Entity
@Table(name = "catalogos_menus")

public class CatalogoMenus implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected CatalogosMenuPK catalogosMenusPK;
    private String descripcion;
    private String orden;
    private boolean activo;
    private String referencia;

    public CatalogoMenus() {
    }

    public CatalogoMenus(CatalogosMenuPK catalogosMenusPK, String descripcion, String orden, boolean activo, String referencia) {
        this.catalogosMenusPK = catalogosMenusPK;
        this.descripcion = descripcion;
        this.orden = orden;
        this.activo = activo;
        this.referencia = referencia;
    }

    public CatalogosMenuPK getCatalogosMenusPK() {
        return catalogosMenusPK;
    }

    public void setCatalogosMenusPK(CatalogosMenuPK catalogosMenusPK) {
        this.catalogosMenusPK = catalogosMenusPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @Override
    public String toString() {
        return "CatalogoMenus{" + "catalogosMenusPK=" + catalogosMenusPK + ", descripcion=" + descripcion + ", orden=" + orden + ", activo=" + activo + ", referencia=" + referencia + '}';
    }
    
    
    
}
