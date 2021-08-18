/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nahum
 */
@Cacheable
@Entity
@Table(name = "negociopropio")
public class Negociopropio implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected NegociopropioPK negociopropioPK;
    private String nombre;
    private String calle;
    private String numeroext;
    private Integer idcolonia;
    private String telefono;
    private String telefono2;
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    private Integer num_empleados;
    private String entrecalles;
    private String numeroint;
    private String rfc;
    private Integer giro_empresa;
    private Integer utilidad_mens;
    private String act_empresarial;
    
    public Negociopropio() {
    }

    public Negociopropio(NegociopropioPK negociopropioPK, String nombre, String calle, String numeroext, Integer idcolonia, String telefono, String telefono2, Date fechainicio, Integer num_empleados, String entrecalles, String numeroint, String rfc, Integer giro_empresa, Integer utilidad_mens, String act_empresarial) {
        this.negociopropioPK = negociopropioPK;
        this.nombre = nombre;
        this.calle = calle;
        this.numeroext = numeroext;
        this.idcolonia = idcolonia;
        this.telefono = telefono;
        this.telefono2 = telefono2;
        this.fechainicio = fechainicio;
        this.num_empleados = num_empleados;
        this.entrecalles = entrecalles;
        this.numeroint = numeroint;
        this.rfc = rfc;
        this.giro_empresa = giro_empresa;
        this.utilidad_mens = utilidad_mens;
        this.act_empresarial = act_empresarial;
    }

    public NegociopropioPK getNegociopropioPK() {
        return negociopropioPK;
    }

    public void setNegociopropioPK(NegociopropioPK negociopropioPK) {
        this.negociopropioPK = negociopropioPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroext() {
        return numeroext;
    }

    public void setNumeroext(String numeroext) {
        this.numeroext = numeroext;
    }

    public Integer getIdcolonia() {
        return idcolonia;
    }

    public void setIdcolonia(Integer idcolonia) {
        this.idcolonia = idcolonia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Integer getNum_empleados() {
        return num_empleados;
    }

    public void setNum_empleados(Integer num_empleados) {
        this.num_empleados = num_empleados;
    }

    public String getEntrecalles() {
        return entrecalles;
    }

    public void setEntrecalles(String entrecalles) {
        this.entrecalles = entrecalles;
    }

    public String getNumeroint() {
        return numeroint;
    }

    public void setNumeroint(String numeroint) {
        this.numeroint = numeroint;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Integer getGiro_empresa() {
        return giro_empresa;
    }

    public void setGiro_empresa(Integer giro_empresa) {
        this.giro_empresa = giro_empresa;
    }

    public Integer getUtilidad_mens() {
        return utilidad_mens;
    }

    public void setUtilidad_mens(Integer utilidad_mens) {
        this.utilidad_mens = utilidad_mens;
    }

    public String getAct_empresarial() {
        return act_empresarial;
    }

    public void setAct_empresarial(String act_empresarial) {
        this.act_empresarial = act_empresarial;
    }

    @Override
    public String toString() {
        return "Negociopropio{" + "negociopropioPK=" + negociopropioPK + ", nombre=" + nombre + ", calle=" + calle + ", numeroext=" + numeroext + ", idcolonia=" + idcolonia + ", telefono=" + telefono + ", telefono2=" + telefono2 + ", fechainicio=" + fechainicio + ", num_empleados=" + num_empleados + ", entrecalles=" + entrecalles + ", numeroint=" + numeroint + ", rfc=" + rfc + ", giro_empresa=" + giro_empresa + ", utilidad_mens=" + utilidad_mens + ", act_empresarial=" + act_empresarial + '}';
    }
    
}
