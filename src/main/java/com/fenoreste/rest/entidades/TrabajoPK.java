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
 public class TrabajoPK implements Serializable {
   @Column(name = "idorigen")
   private Integer idtorigen;   
   @Column(name = "idgrupo")
   private Integer idgrupo; 
   @Column(name = "idsocio")
   private Integer idsocio; 
   @Column(name="consecutivo")
   private Integer consecutivo;

    public TrabajoPK() {
    }

    public TrabajoPK(Integer idtorigen, Integer idgrupo, Integer idsocio, Integer consecutivo) {
        this.idtorigen = idtorigen;
        this.idgrupo = idgrupo;
        this.idsocio = idsocio;
        this.consecutivo = consecutivo;
    }

    public Integer getIdtorigen() {
        return idtorigen;
    }

    public void setIdtorigen(Integer idtorigen) {
        this.idtorigen = idtorigen;
    }

    public Integer getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(Integer idgrupo) {
        this.idgrupo = idgrupo;
    }

    public Integer getIdsocio() {
        return idsocio;
    }

    public void setIdsocio(Integer idsocio) {
        this.idsocio = idsocio;
    }

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }
    
}
