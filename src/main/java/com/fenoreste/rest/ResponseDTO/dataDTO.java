/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.ResponseDTO;

import java.util.List;

/**
 *
 * @author wilmer
 */
public class dataDTO {

    private String es_socio;
    private String num_socio;
    private String primer_nombre;
    private String apellidos;
    private String numero_documento;
    private String telefono_Celular;
    private String fecha_nacimiento;
    private String lugar_nacimiento;
    private String personas_viven_en_casa;
    private String jubilado;
    private String fecha_ingreso_laboral;
    private String ingresos_mensuales;
    private String estado;
    private String ciudad;
    private String direccion;
    private String codigo_postal;
    private String propiedad_vivienda;
    private String email;
    private String ultimo_estudio_cursado;
    private String telefono_auxiliar;
    private String antiguedad_domicilio;
    private String num_socio_conyugue;
    private String cant_hijos;
    private String rubro_laboral;
    private String telefono_trabajo;
    private String monto_maximo_a_prestar;
    private String numero_cuenta;
    private String es_socio_comercial;

    private String reca_completo;
    private String reca_recortado;
    private String ogs;
    private String opa;
    private String cat;
    private String numero_producto;
    private String clasificacion_cartera;
    private String id_solicitud_siscore;
    private String folio_prestamo;
    private String numero_folio_poliza;
    private String numero_pagare;
    private String fecha_vencimiento_pagare;
    private String resumen_calificacion;
    private String regimen_patrimonial;
    private String numero_dependientes;
    private String telefono_recados;
    private String monto_ahorro;
    private String proteccion_ahorro_prestamo;
    private String garantia_liquida;
    private String tipo_garantia;
    private String deposito_garantia_letras;
    private String antiguedad_socio;
    private String parte_social;
    private String fideicomiso;
    private String historial_cooperativa;
    private String linea_credito;
    private String linea_credito_letras;
    private String aseguradora;
    private String clausulas;
    private String modalidad_pago;
    private String tipo_operacion;
    private String datos_del_poder;
    private String disponibilidad;
    private String porcentaje_capacidad;
    private String idauxiliar;
    private String idorigenp;
    private String sexo;

    private String fuente_ingresos_fijos;
    private String monto_ingresos_fijos;
    private String fuente_ingresos_variables;
    private String monto_ingresos_variables;
    private String gastos_alimentacion;
    private String gastos_pagos_servicios;

    private String fecha_ingreso_caja;

    private String total_ingresos;
    private String otros_ingresos;
    private String fuentes_otros_ingresos;

    private String total_valor_propiedades;

    private comercioDTO comercio;
    private referenciasDTO referencias;
    private primerEmpleoDTO primer_empleo;
    private segundoEmpleoDTO segundo_empleo;
    private negocioDTO negocio;
    private gastosDTO gatos;
    private List<propiedadesDTO> propiedades;
    private conyugueDTO conyugue;
    private avalDTO aval;
    private codeudorDTO codeudor;
    private List<referenciasPersonalesDTO> referencias_personales;
    private referenciasLaboralesDTO referencias_laborales;
    private List<relacionesSociosDTO> relaciones_socios;

    public dataDTO() {

    }

    public dataDTO(String es_socio, String num_socio, String primer_nombre, String apellidos, String numero_documento, String telefono_Celular, String fecha_nacimiento, String lugar_nacimiento, String personas_viven_en_casa, String jubilado, String fecha_ingreso_laboral, String ingresos_mensuales, String estado, String ciudad, String direccion, String codigo_postal, String propiedad_vivienda, String email, String ultimo_estudio_cursado, String telefono_auxiliar, String antiguedad_domicilio, String num_socio_conyugue, String cant_hijos, String rubro_laboral, String telefono_trabajo, String monto_maximo_a_prestar, String numero_cuenta, String es_socio_comercial, String reca_completo, String reca_recortado, String ogs, String opa, String cat, String numero_producto, String clasificacion_cartera, String id_solicitud_siscore, String folio_prestamo, String numero_folio_poliza, String numero_pagare, String fecha_vencimiento_pagare, String resumen_calificacion, String regimen_patrimonial, String numero_dependientes, String telefono_recados, String monto_ahorro, String proteccion_ahorro_prestamo, String garantia_liquida, String tipo_garantia, String deposito_garantia_letras, String antiguedad_socio, String parte_social, String fideicomiso, String historial_cooperativa, String linea_credito, String linea_credito_letras, String aseguradora, String clausulas, String modalidad_pago, String tipo_operacion, String datos_del_poder, String disponibilidad, String porcentaje_capacidad, String idauxiliar, String idorigenp, String sexo, String fuente_ingresos_fijos, String monto_ingresos_fijos, String fuente_ingresos_variables, String monto_ingresos_variables, String gastos_alimentacion, String gastos_pagos_servicios, String fecha_ingreso_caja, String total_ingresos, String otros_ingresos, String fuentes_otros_ingresos, String total_valor_propiedades, comercioDTO comercio, referenciasDTO referencias, primerEmpleoDTO primer_empleo, segundoEmpleoDTO segundo_empleo, negocioDTO negocio, gastosDTO gatos, List<propiedadesDTO> propiedades, conyugueDTO conyugue, avalDTO aval, codeudorDTO codeudor, List<referenciasPersonalesDTO> referencias_personales, referenciasLaboralesDTO referencias_laborales, List<relacionesSociosDTO> relaciones_socios) {
        this.es_socio = es_socio;
        this.num_socio = num_socio;
        this.primer_nombre = primer_nombre;
        this.apellidos = apellidos;
        this.numero_documento = numero_documento;
        this.telefono_Celular = telefono_Celular;
        this.fecha_nacimiento = fecha_nacimiento;
        this.lugar_nacimiento = lugar_nacimiento;
        this.personas_viven_en_casa = personas_viven_en_casa;
        this.jubilado = jubilado;
        this.fecha_ingreso_laboral = fecha_ingreso_laboral;
        this.ingresos_mensuales = ingresos_mensuales;
        this.estado = estado;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.codigo_postal = codigo_postal;
        this.propiedad_vivienda = propiedad_vivienda;
        this.email = email;
        this.ultimo_estudio_cursado = ultimo_estudio_cursado;
        this.telefono_auxiliar = telefono_auxiliar;
        this.antiguedad_domicilio = antiguedad_domicilio;
        this.num_socio_conyugue = num_socio_conyugue;
        this.cant_hijos = cant_hijos;
        this.rubro_laboral = rubro_laboral;
        this.telefono_trabajo = telefono_trabajo;
        this.monto_maximo_a_prestar = monto_maximo_a_prestar;
        this.numero_cuenta = numero_cuenta;
        this.es_socio_comercial = es_socio_comercial;
        this.reca_completo = reca_completo;
        this.reca_recortado = reca_recortado;
        this.ogs = ogs;
        this.opa = opa;
        this.cat = cat;
        this.numero_producto = numero_producto;
        this.clasificacion_cartera = clasificacion_cartera;
        this.id_solicitud_siscore = id_solicitud_siscore;
        this.folio_prestamo = folio_prestamo;
        this.numero_folio_poliza = numero_folio_poliza;
        this.numero_pagare = numero_pagare;
        this.fecha_vencimiento_pagare = fecha_vencimiento_pagare;
        this.resumen_calificacion = resumen_calificacion;
        this.regimen_patrimonial = regimen_patrimonial;
        this.numero_dependientes = numero_dependientes;
        this.telefono_recados = telefono_recados;
        this.monto_ahorro = monto_ahorro;
        this.proteccion_ahorro_prestamo = proteccion_ahorro_prestamo;
        this.garantia_liquida = garantia_liquida;
        this.tipo_garantia = tipo_garantia;
        this.deposito_garantia_letras = deposito_garantia_letras;
        this.antiguedad_socio = antiguedad_socio;
        this.parte_social = parte_social;
        this.fideicomiso = fideicomiso;
        this.historial_cooperativa = historial_cooperativa;
        this.linea_credito = linea_credito;
        this.linea_credito_letras = linea_credito_letras;
        this.aseguradora = aseguradora;
        this.clausulas = clausulas;
        this.modalidad_pago = modalidad_pago;
        this.tipo_operacion = tipo_operacion;
        this.datos_del_poder = datos_del_poder;
        this.disponibilidad = disponibilidad;
        this.porcentaje_capacidad = porcentaje_capacidad;
        this.idauxiliar = idauxiliar;
        this.idorigenp = idorigenp;
        this.sexo = sexo;
        this.fuente_ingresos_fijos = fuente_ingresos_fijos;
        this.monto_ingresos_fijos = monto_ingresos_fijos;
        this.fuente_ingresos_variables = fuente_ingresos_variables;
        this.monto_ingresos_variables = monto_ingresos_variables;
        this.gastos_alimentacion = gastos_alimentacion;
        this.gastos_pagos_servicios = gastos_pagos_servicios;
        this.fecha_ingreso_caja = fecha_ingreso_caja;
        this.total_ingresos = total_ingresos;
        this.otros_ingresos = otros_ingresos;
        this.fuentes_otros_ingresos = fuentes_otros_ingresos;
        this.total_valor_propiedades = total_valor_propiedades;
        this.comercio = comercio;
        this.referencias = referencias;
        this.primer_empleo = primer_empleo;
        this.segundo_empleo = segundo_empleo;
        this.negocio = negocio;
        this.gatos = gatos;
        this.propiedades = propiedades;
        this.conyugue = conyugue;
        this.aval = aval;
        this.codeudor = codeudor;
        this.referencias_personales = referencias_personales;
        this.referencias_laborales = referencias_laborales;
        this.relaciones_socios = relaciones_socios;
    }

    public String getEs_socio() {
        return es_socio;
    }

    public void setEs_socio(String es_socio) {
        this.es_socio = es_socio;
    }

    public String getNum_socio() {
        return num_socio;
    }

    public void setNum_socio(String num_socio) {
        this.num_socio = num_socio;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getTelefono_Celular() {
        return telefono_Celular;
    }

    public void setTelefono_Celular(String telefono_Celular) {
        this.telefono_Celular = telefono_Celular;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getLugar_nacimiento() {
        return lugar_nacimiento;
    }

    public void setLugar_nacimiento(String lugar_nacimiento) {
        this.lugar_nacimiento = lugar_nacimiento;
    }

    public String getPersonas_viven_en_casa() {
        return personas_viven_en_casa;
    }

    public void setPersonas_viven_en_casa(String personas_viven_en_casa) {
        this.personas_viven_en_casa = personas_viven_en_casa;
    }

    public String getJubilado() {
        return jubilado;
    }

    public void setJubilado(String jubilado) {
        this.jubilado = jubilado;
    }

    public String getFecha_ingreso_laboral() {
        return fecha_ingreso_laboral;
    }

    public void setFecha_ingreso_laboral(String fecha_ingreso_laboral) {
        this.fecha_ingreso_laboral = fecha_ingreso_laboral;
    }

    public String getIngresos_mensuales() {
        return ingresos_mensuales;
    }

    public void setIngresos_mensuales(String ingresos_mensuales) {
        this.ingresos_mensuales = ingresos_mensuales;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getPropiedad_vivienda() {
        return propiedad_vivienda;
    }

    public void setPropiedad_vivienda(String propiedad_vivienda) {
        this.propiedad_vivienda = propiedad_vivienda;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUltimo_estudio_cursado() {
        return ultimo_estudio_cursado;
    }

    public void setUltimo_estudio_cursado(String ultimo_estudio_cursado) {
        this.ultimo_estudio_cursado = ultimo_estudio_cursado;
    }

    public String getTelefono_auxiliar() {
        return telefono_auxiliar;
    }

    public void setTelefono_auxiliar(String telefono_auxiliar) {
        this.telefono_auxiliar = telefono_auxiliar;
    }

    public String getAntiguedad_domicilio() {
        return antiguedad_domicilio;
    }

    public void setAntiguedad_domicilio(String antiguedad_domicilio) {
        this.antiguedad_domicilio = antiguedad_domicilio;
    }

    public String getNum_socio_conyugue() {
        return num_socio_conyugue;
    }

    public void setNum_socio_conyugue(String num_socio_conyugue) {
        this.num_socio_conyugue = num_socio_conyugue;
    }

    public String getCant_hijos() {
        return cant_hijos;
    }

    public void setCant_hijos(String cant_hijos) {
        this.cant_hijos = cant_hijos;
    }

    public String getRubro_laboral() {
        return rubro_laboral;
    }

    public void setRubro_laboral(String rubro_laboral) {
        this.rubro_laboral = rubro_laboral;
    }

    public String getTelefono_trabajo() {
        return telefono_trabajo;
    }

    public void setTelefono_trabajo(String telefono_trabajo) {
        this.telefono_trabajo = telefono_trabajo;
    }

    public String getMonto_maximo_a_prestar() {
        return monto_maximo_a_prestar;
    }

    public void setMonto_maximo_a_prestar(String monto_maximo_a_prestar) {
        this.monto_maximo_a_prestar = monto_maximo_a_prestar;
    }

    public String getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public String getEs_socio_comercial() {
        return es_socio_comercial;
    }

    public void setEs_socio_comercial(String es_socio_comercial) {
        this.es_socio_comercial = es_socio_comercial;
    }

    public String getReca_completo() {
        return reca_completo;
    }

    public void setReca_completo(String reca_completo) {
        this.reca_completo = reca_completo;
    }

    public String getReca_recortado() {
        return reca_recortado;
    }

    public void setReca_recortado(String reca_recortado) {
        this.reca_recortado = reca_recortado;
    }

    public String getOgs() {
        return ogs;
    }

    public void setOgs(String ogs) {
        this.ogs = ogs;
    }

    public String getOpa() {
        return opa;
    }

    public void setOpa(String opa) {
        this.opa = opa;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getNumero_producto() {
        return numero_producto;
    }

    public void setNumero_producto(String numero_producto) {
        this.numero_producto = numero_producto;
    }

    public String getClasificacion_cartera() {
        return clasificacion_cartera;
    }

    public void setClasificacion_cartera(String clasificacion_cartera) {
        this.clasificacion_cartera = clasificacion_cartera;
    }

    public String getId_solicitud_siscore() {
        return id_solicitud_siscore;
    }

    public void setId_solicitud_siscore(String id_solicitud_siscore) {
        this.id_solicitud_siscore = id_solicitud_siscore;
    }

    public String getFolio_prestamo() {
        return folio_prestamo;
    }

    public void setFolio_prestamo(String folio_prestamo) {
        this.folio_prestamo = folio_prestamo;
    }

    public String getNumero_folio_poliza() {
        return numero_folio_poliza;
    }

    public void setNumero_folio_poliza(String numero_folio_poliza) {
        this.numero_folio_poliza = numero_folio_poliza;
    }

    public String getNumero_pagare() {
        return numero_pagare;
    }

    public void setNumero_pagare(String numero_pagare) {
        this.numero_pagare = numero_pagare;
    }

    public String getFecha_vencimiento_pagare() {
        return fecha_vencimiento_pagare;
    }

    public void setFecha_vencimiento_pagare(String fecha_vencimiento_pagare) {
        this.fecha_vencimiento_pagare = fecha_vencimiento_pagare;
    }

    public String getResumen_calificacion() {
        return resumen_calificacion;
    }

    public void setResumen_calificacion(String resumen_calificacion) {
        this.resumen_calificacion = resumen_calificacion;
    }

    public String getRegimen_patrimonial() {
        return regimen_patrimonial;
    }

    public void setRegimen_patrimonial(String regimen_patrimonial) {
        this.regimen_patrimonial = regimen_patrimonial;
    }

    public String getNumero_dependientes() {
        return numero_dependientes;
    }

    public void setNumero_dependientes(String numero_dependientes) {
        this.numero_dependientes = numero_dependientes;
    }

    public String getTelefono_recados() {
        return telefono_recados;
    }

    public void setTelefono_recados(String telefono_recados) {
        this.telefono_recados = telefono_recados;
    }

    public String getMonto_ahorro() {
        return monto_ahorro;
    }

    public void setMonto_ahorro(String monto_ahorro) {
        this.monto_ahorro = monto_ahorro;
    }

    public String getProteccion_ahorro_prestamo() {
        return proteccion_ahorro_prestamo;
    }

    public void setProteccion_ahorro_prestamo(String proteccion_ahorro_prestamo) {
        this.proteccion_ahorro_prestamo = proteccion_ahorro_prestamo;
    }

    public String getGarantia_liquida() {
        return garantia_liquida;
    }

    public void setGarantia_liquida(String garantia_liquida) {
        this.garantia_liquida = garantia_liquida;
    }

    public String getTipo_garantia() {
        return tipo_garantia;
    }

    public void setTipo_garantia(String tipo_garantia) {
        this.tipo_garantia = tipo_garantia;
    }

    public String getDeposito_garantia_letras() {
        return deposito_garantia_letras;
    }

    public void setDeposito_garantia_letras(String deposito_garantia_letras) {
        this.deposito_garantia_letras = deposito_garantia_letras;
    }

    public String getAntiguedad_socio() {
        return antiguedad_socio;
    }

    public void setAntiguedad_socio(String antiguedad_socio) {
        this.antiguedad_socio = antiguedad_socio;
    }

    public String getParte_social() {
        return parte_social;
    }

    public void setParte_social(String parte_social) {
        this.parte_social = parte_social;
    }

    public String getFideicomiso() {
        return fideicomiso;
    }

    public void setFideicomiso(String fideicomiso) {
        this.fideicomiso = fideicomiso;
    }

    public String getHistorial_cooperativa() {
        return historial_cooperativa;
    }

    public void setHistorial_cooperativa(String historial_cooperativa) {
        this.historial_cooperativa = historial_cooperativa;
    }

    public String getLinea_credito() {
        return linea_credito;
    }

    public void setLinea_credito(String linea_credito) {
        this.linea_credito = linea_credito;
    }

    public String getLinea_credito_letras() {
        return linea_credito_letras;
    }

    public void setLinea_credito_letras(String linea_credito_letras) {
        this.linea_credito_letras = linea_credito_letras;
    }

    public String getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(String aseguradora) {
        this.aseguradora = aseguradora;
    }

    public String getClausulas() {
        return clausulas;
    }

    public void setClausulas(String clausulas) {
        this.clausulas = clausulas;
    }

    public String getModalidad_pago() {
        return modalidad_pago;
    }

    public void setModalidad_pago(String modalidad_pago) {
        this.modalidad_pago = modalidad_pago;
    }

    public String getTipo_operacion() {
        return tipo_operacion;
    }

    public void setTipo_operacion(String tipo_operacion) {
        this.tipo_operacion = tipo_operacion;
    }

    public String getDatos_del_poder() {
        return datos_del_poder;
    }

    public void setDatos_del_poder(String datos_del_poder) {
        this.datos_del_poder = datos_del_poder;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getPorcentaje_capacidad() {
        return porcentaje_capacidad;
    }

    public void setPorcentaje_capacidad(String porcentaje_capacidad) {
        this.porcentaje_capacidad = porcentaje_capacidad;
    }

    public String getIdauxiliar() {
        return idauxiliar;
    }

    public void setIdauxiliar(String idauxiliar) {
        this.idauxiliar = idauxiliar;
    }

    public String getIdorigenp() {
        return idorigenp;
    }

    public void setIdorigenp(String idorigenp) {
        this.idorigenp = idorigenp;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFuente_ingresos_fijos() {
        return fuente_ingresos_fijos;
    }

    public void setFuente_ingresos_fijos(String fuente_ingresos_fijos) {
        this.fuente_ingresos_fijos = fuente_ingresos_fijos;
    }

    public String getMonto_ingresos_fijos() {
        return monto_ingresos_fijos;
    }

    public void setMonto_ingresos_fijos(String monto_ingresos_fijos) {
        this.monto_ingresos_fijos = monto_ingresos_fijos;
    }

    public String getFuente_ingresos_variables() {
        return fuente_ingresos_variables;
    }

    public void setFuente_ingresos_variables(String fuente_ingresos_variables) {
        this.fuente_ingresos_variables = fuente_ingresos_variables;
    }

    public String getMonto_ingresos_variables() {
        return monto_ingresos_variables;
    }

    public void setMonto_ingresos_variables(String monto_ingresos_variables) {
        this.monto_ingresos_variables = monto_ingresos_variables;
    }

    public String getGastos_alimentacion() {
        return gastos_alimentacion;
    }

    public void setGastos_alimentacion(String gastos_alimentacion) {
        this.gastos_alimentacion = gastos_alimentacion;
    }

    public String getGastos_pagos_servicios() {
        return gastos_pagos_servicios;
    }

    public void setGastos_pagos_servicios(String gastos_pagos_servicios) {
        this.gastos_pagos_servicios = gastos_pagos_servicios;
    }

    public String getFecha_ingreso_caja() {
        return fecha_ingreso_caja;
    }

    public void setFecha_ingreso_caja(String fecha_ingreso_caja) {
        this.fecha_ingreso_caja = fecha_ingreso_caja;
    }

    public String getTotal_ingresos() {
        return total_ingresos;
    }

    public void setTotal_ingresos(String total_ingresos) {
        this.total_ingresos = total_ingresos;
    }

    public String getOtros_ingresos() {
        return otros_ingresos;
    }

    public void setOtros_ingresos(String otros_ingresos) {
        this.otros_ingresos = otros_ingresos;
    }

    public String getFuentes_otros_ingresos() {
        return fuentes_otros_ingresos;
    }

    public void setFuentes_otros_ingresos(String fuentes_otros_ingresos) {
        this.fuentes_otros_ingresos = fuentes_otros_ingresos;
    }

    public String getTotal_valor_propiedades() {
        return total_valor_propiedades;
    }

    public void setTotal_valor_propiedades(String total_valor_propiedades) {
        this.total_valor_propiedades = total_valor_propiedades;
    }

    public comercioDTO getComercio() {
        return comercio;
    }

    public void setComercio(comercioDTO comercio) {
        this.comercio = comercio;
    }

    public referenciasDTO getReferencias() {
        return referencias;
    }

    public void setReferencias(referenciasDTO referencias) {
        this.referencias = referencias;
    }

    public primerEmpleoDTO getPrimer_empleo() {
        return primer_empleo;
    }

    public void setPrimer_empleo(primerEmpleoDTO primer_empleo) {
        this.primer_empleo = primer_empleo;
    }

    public segundoEmpleoDTO getSegundo_empleo() {
        return segundo_empleo;
    }

    public void setSegundo_empleo(segundoEmpleoDTO segundo_empleo) {
        this.segundo_empleo = segundo_empleo;
    }

    public negocioDTO getNegocio() {
        return negocio;
    }

    public void setNegocio(negocioDTO negocio) {
        this.negocio = negocio;
    }

    public gastosDTO getGatos() {
        return gatos;
    }

    public void setGatos(gastosDTO gatos) {
        this.gatos = gatos;
    }

    public List<propiedadesDTO> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<propiedadesDTO> propiedades) {
        this.propiedades = propiedades;
    }

    public conyugueDTO getConyugue() {
        return conyugue;
    }

    public void setConyugue(conyugueDTO conyugue) {
        this.conyugue = conyugue;
    }

    public avalDTO getAval() {
        return aval;
    }

    public void setAval(avalDTO aval) {
        this.aval = aval;
    }

    public codeudorDTO getCodeudor() {
        return codeudor;
    }

    public void setCodeudor(codeudorDTO codeudor) {
        this.codeudor = codeudor;
    }

    public List<referenciasPersonalesDTO> getReferencias_personales() {
        return referencias_personales;
    }

    public void setReferencias_personales(List<referenciasPersonalesDTO> referencias_personales) {
        this.referencias_personales = referencias_personales;
    }

    public referenciasLaboralesDTO getReferencias_laborales() {
        return referencias_laborales;
    }

    public void setReferencias_laborales(referenciasLaboralesDTO referencias_laborales) {
        this.referencias_laborales = referencias_laborales;
    }

    public List<relacionesSociosDTO> getRelaciones_socios() {
        return relaciones_socios;
    }

    public void setRelaciones_socios(List<relacionesSociosDTO> relaciones_socios) {
        this.relaciones_socios = relaciones_socios;
    }

    @Override
    public String toString() {
        return "dataDTO{" + "es_socio=" + es_socio + ", num_socio=" + num_socio + ", primer_nombre=" + primer_nombre + ", apellidos=" + apellidos + ", numero_documento=" + numero_documento + ", telefono_Celular=" + telefono_Celular + ", fecha_nacimiento=" + fecha_nacimiento + ", lugar_nacimiento=" + lugar_nacimiento + ", personas_viven_en_casa=" + personas_viven_en_casa + ", jubilado=" + jubilado + ", fecha_ingreso_laboral=" + fecha_ingreso_laboral + ", ingresos_mensuales=" + ingresos_mensuales + ", estado=" + estado + ", ciudad=" + ciudad + ", direccion=" + direccion + ", codigo_postal=" + codigo_postal + ", propiedad_vivienda=" + propiedad_vivienda + ", email=" + email + ", ultimo_estudio_cursado=" + ultimo_estudio_cursado + ", telefono_auxiliar=" + telefono_auxiliar + ", antiguedad_domicilio=" + antiguedad_domicilio + ", num_socio_conyugue=" + num_socio_conyugue + ", cant_hijos=" + cant_hijos + ", rubro_laboral=" + rubro_laboral + ", telefono_trabajo=" + telefono_trabajo + ", monto_maximo_a_prestar=" + monto_maximo_a_prestar + ", numero_cuenta=" + numero_cuenta + ", es_socio_comercial=" + es_socio_comercial + ", reca_completo=" + reca_completo + ", reca_recortado=" + reca_recortado + ", ogs=" + ogs + ", opa=" + opa + ", cat=" + cat + ", numero_producto=" + numero_producto + ", clasificacion_cartera=" + clasificacion_cartera + ", id_solicitud_siscore=" + id_solicitud_siscore + ", folio_prestamo=" + folio_prestamo + ", numero_folio_poliza=" + numero_folio_poliza + ", numero_pagare=" + numero_pagare + ", fecha_vencimiento_pagare=" + fecha_vencimiento_pagare + ", resumen_calificacion=" + resumen_calificacion + ", regimen_patrimonial=" + regimen_patrimonial + ", numero_dependientes=" + numero_dependientes + ", telefono_recados=" + telefono_recados + ", monto_ahorro=" + monto_ahorro + ", proteccion_ahorro_prestamo=" + proteccion_ahorro_prestamo + ", garantia_liquida=" + garantia_liquida + ", tipo_garantia=" + tipo_garantia + ", deposito_garantia_letras=" + deposito_garantia_letras + ", antiguedad_socio=" + antiguedad_socio + ", parte_social=" + parte_social + ", fideicomiso=" + fideicomiso + ", historial_cooperativa=" + historial_cooperativa + ", linea_credito=" + linea_credito + ", linea_credito_letras=" + linea_credito_letras + ", aseguradora=" + aseguradora + ", clausulas=" + clausulas + ", modalidad_pago=" + modalidad_pago + ", tipo_operacion=" + tipo_operacion + ", datos_del_poder=" + datos_del_poder + ", disponibilidad=" + disponibilidad + ", porcentaje_capacidad=" + porcentaje_capacidad + ", idauxiliar=" + idauxiliar + ", idorigenp=" + idorigenp + ", sexo=" + sexo + ", fuente_ingresos_fijos=" + fuente_ingresos_fijos + ", monto_ingresos_fijos=" + monto_ingresos_fijos + ", fuente_ingresos_variables=" + fuente_ingresos_variables + ", monto_ingresos_variables=" + monto_ingresos_variables + ", gastos_alimentacion=" + gastos_alimentacion + ", gastos_pagos_servicios=" + gastos_pagos_servicios + ", fecha_ingreso_caja=" + fecha_ingreso_caja + ", total_ingresos=" + total_ingresos + ", otros_ingresos=" + otros_ingresos + ", fuentes_otros_ingresos=" + fuentes_otros_ingresos + ", total_valor_propiedades=" + total_valor_propiedades + ", comercio=" + comercio + ", referencias=" + referencias + ", primer_empleo=" + primer_empleo + ", segundo_empleo=" + segundo_empleo + ", negocio=" + negocio + ", gatos=" + gatos + ", propiedades=" + propiedades + ", conyugue=" + conyugue + ", aval=" + aval + ", codeudor=" + codeudor + ", referencias_personales=" + referencias_personales + ", referencias_laborales=" + referencias_laborales + ", relaciones_socios=" + relaciones_socios + '}';
    }
    
    

}
