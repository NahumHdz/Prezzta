/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.entidades;

import java.io.Serializable;
import javax.persistence.Cacheable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author nahum
 */
@Cacheable(false)
@Entity
@Table(name = "referencias")
public class Referencias implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected ReferenciasPK referenciaPK;
    private String referencia;
    private Integer idorigenr;
    private Integer idgrupor;
    private Integer idsocior;
    
    public Referencias() {
    }

    public Referencias(ReferenciasPK referenciaPK, String referencia, Integer idorigenr, Integer idgrupor, Integer idsocior) {
        this.referenciaPK = referenciaPK;
        this.referencia = referencia;
        this.idorigenr = idorigenr;
        this.idgrupor = idgrupor;
        this.idsocior = idsocior;
    }

    public ReferenciasPK getReferenciaPK() {
        return referenciaPK;
    }

    public void setReferenciaPK(ReferenciasPK referenciaPK) {
        this.referenciaPK = referenciaPK;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getIdorigenr() {
        return idorigenr;
    }

    public void setIdorigenr(Integer idorigenr) {
        this.idorigenr = idorigenr;
    }

    public Integer getIdgrupor() {
        return idgrupor;
    }

    public void setIdgrupor(Integer idgrupor) {
        this.idgrupor = idgrupor;
    }

    public Integer getIdsocior() {
        return idsocior;
    }

    public void setIdsocior(Integer idsocior) {
        this.idsocior = idsocior;
    }
    
}
