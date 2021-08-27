/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.ResponseDTO;

/**
 *
 * @author wilmer
 */
public class primerEmpleoDTO {
    private String ocupacion;
    private String puesto;
    private String telefono;
    private String giro;
    private String codigo_postal;
    private String calle;
    private String numero_exterior;
    private String numero_interior;
    private String colonia;
    private String municipio;
    private String estado;
    
    public primerEmpleoDTO() {
    }

    public primerEmpleoDTO(String ocupacion, String puesto, String telefono, String giro, String codigo_postal, String calle, String numero_exterior, String numero_interior, String colonia, String municipio, String estado) {
        this.ocupacion = ocupacion;
        this.puesto = puesto;
        this.telefono = telefono;
        this.giro = giro;
        this.codigo_postal = codigo_postal;
        this.calle = calle;
        this.numero_exterior = numero_exterior;
        this.numero_interior = numero_interior;
        this.colonia = colonia;
        this.municipio = municipio;
        this.estado = estado;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero_exterior() {
        return numero_exterior;
    }

    public void setNumero_exterior(String numero_exterior) {
        this.numero_exterior = numero_exterior;
    }

    public String getNumero_interior() {
        return numero_interior;
    }

    public void setNumero_interior(String numero_interior) {
        this.numero_interior = numero_interior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "primerEmpleoDTO{" + "ocupacion=" + ocupacion + ", puesto=" + puesto + ", telefono=" + telefono + ", giro=" + giro + ", codigo_postal=" + codigo_postal + ", calle=" + calle + ", numero_exterior=" + numero_exterior + ", numero_interior=" + numero_interior + ", colonia=" + colonia + ", municipio=" + municipio + ", estado=" + estado + '}';
    }
    
}
