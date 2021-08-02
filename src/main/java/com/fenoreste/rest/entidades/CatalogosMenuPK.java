/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.entidades;

import java.io.Serializable;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author wilmer
 */
@Cacheable(false)
@Embeddable
public class CatalogosMenuPK implements Serializable {
    @Column(name = "menu")
    private String menu;
    @Column(name = "opcion")
    private Integer opcion;

    public CatalogosMenuPK() {
    }

    public CatalogosMenuPK(String menu, Integer opcion) {
        this.menu = menu;
        this.opcion = opcion;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public Integer getOpcion() {
        return opcion;
    }

    public void setOpcion(Integer opcion) {
        this.opcion = opcion;
    }
    
    

    }
