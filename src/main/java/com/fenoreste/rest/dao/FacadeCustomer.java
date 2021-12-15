package com.fenoreste.rest.dao;

import com.fenoreste.rest.entidades.Persona;
import com.fenoreste.rest.Util.AbstractFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import com.fenoreste.rest.ResponseDTO.*;
import com.fenoreste.rest.entidades.Auxiliares;
import com.fenoreste.rest.entidades.CatalogoMenus;
import com.fenoreste.rest.entidades.CatalogosMenuPK;
import com.fenoreste.rest.entidades.Colonias;
import com.fenoreste.rest.entidades.Estados;
import com.fenoreste.rest.entidades.Municipios;
import com.fenoreste.rest.entidades.Negociopropio;
import com.fenoreste.rest.entidades.NegociopropioPK;
import com.fenoreste.rest.entidades.PersonasPK;
import com.fenoreste.rest.entidades.Socioeconomicos;
import com.fenoreste.rest.entidades.SocioeconomicosPK;
import com.fenoreste.rest.entidades.Tablas;
import com.fenoreste.rest.entidades.TablasPK;
import com.fenoreste.rest.entidades.Trabajo;
import com.fenoreste.rest.entidades.TrabajoPK;
import com.fenoreste.rest.entidades.Referencias;
import com.fenoreste.rest.entidades.ReferenciasPK;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public abstract class FacadeCustomer<T> {
    
    private static EntityManagerFactory emf;
    
    List<Object[]> lista = null;
    
    public FacadeCustomer(Class<T> entityClass) {
        emf = AbstractFacade.conexion();
    }
    
    public dataDTO clientInfo(Persona persona) {
        EntityManager em = emf.createEntityManager();
        InfoClienteDTO info = new InfoClienteDTO();
        dataDTO data = new dataDTO();
        try {//Iniciando
            //Buscamos la parte social para saber si es un socio
            TablasPK tbpk = new TablasPK("prezzta", "parte_social");
            Tablas tb = em.find(Tablas.class, tbpk);
            //Si la tabla esta configurada
            System.out.println("paso paso");
            if (tb != null) {
                //Buscamos el producto de parte social y que tenga el saldo
                String consultaPS = "SELECT * FROM auxiliares WHERE idorigen=" + persona.getPersonasPK().getIdorigen()
                        + " AND idgrupo=" + persona.getPersonasPK().getIdgrupo()
                        + " AND idsocio=" + persona.getPersonasPK().getIdsocio()
                        + " AND idproducto=" + tb.getDato1();
                System.out.println("ConsultaParteSocial:" + consultaPS);
                Query queryPS = em.createNativeQuery(consultaPS, Auxiliares.class);
                System.out.println("paso");
                Auxiliares a = (Auxiliares) queryPS.getSingleResult();
                //Si existe el producto con la parte social
                if (a != null) {
                    //Si el saldo que tiene el producto con la parte social es igual a lo que hay en tablas 
                    if (Double.parseDouble(a.getSaldo().toString()) == Double.parseDouble(tb.getDato2())) {
                        //Es un socio
                        data.setEs_socio("1");
                        //Formamos el ogs
                        String o=String.format("%06d",a.getIdorigen());
                        String g=String.format("%02d",a.getIdgrupo());
                        String s=String.format("%06d",a.getIdsocio());
                        data.setNum_socio(o+g+s);
                        data.setPrimer_nombre(persona.getNombre());
                        data.setApellidos(persona.getAppaterno()+" "+persona.getApmaterno());
                        data.setNumero_documento(persona.getCurp());
                        data.setTelefono_Celular(persona.getCelular());
                        data.setFecha_nacimiento(persona.getFechanacimiento().toString());
                        data.setLugar_nacimiento(persona.getLugarnacimiento());
                        SocioeconomicosPK socioeconomicosPK = new SocioeconomicosPK(a.getIdorigen(),a.getIdgrupo(),a.getIdsocio());
                        Socioeconomicos socioeconomicos = em.find(Socioeconomicos.class,socioeconomicosPK);
                        data.setPersonas_viven_en_casa(String.valueOf(socioeconomicos.getDependientes()));
                        
                        String trabajos = "SELECT * FROM trabajo WHERE idorigen = "+ persona.getPersonasPK().getIdorigen()
                                        + " AND idgrupo = " + persona.getPersonasPK().getIdgrupo() 
                                        + " AND idsocio = " + persona.getPersonasPK().getIdsocio()
                                        + " AND fechasalida IS NULL ORDER BY consecutivo DESC limit 2";
                        System.out.println("QUERY TRABAJO: " + trabajos);
                        Query query = em.createNativeQuery(trabajos);
                        List<Object[]> listaTr = query.getResultList();
                        primerEmpleoDTO primerempleo = new primerEmpleoDTO();
                        segundoEmpleoDTO segundoempleo = new segundoEmpleoDTO();
                        int cons_tr_ac = 0; ///////////////consecutivo trabajo actual
                        for(int i=0;i<listaTr.size();i++) {
                            Object[] oo = listaTr.get(i);
                            System.out.println("Lista:"+oo[3]);
                            if(i==0){
                                cons_tr_ac = (int) oo[18];
                                CatalogosMenuPK menuge1 = new CatalogosMenuPK("giro_empresa", Integer.parseInt(oo[15].toString()));
                                CatalogoMenus cm1em = em.find(CatalogoMenus.class, menuge1);
                                Colonias c1em = em.find(Colonias.class,oo[6]);
                                Municipios m1em = em.find(Municipios.class, c1em.getIdmunicipio());
                                Estados e1em = em.find(Estados.class, m1em.getIdestado());
                                if (oo[9] != null) { primerempleo.setOcupacion(oo[9].toString()); } else { primerempleo.setOcupacion(""); }
                                primerempleo.setPuesto(oo[11].toString());
                                primerempleo.setTelefono(oo[7].toString());
                                primerempleo.setGiro(cm1em.getDescripcion());
                                primerempleo.setCodigo_postal(c1em.getCodigopostal());
                                primerempleo.setCalle(oo[4].toString());
                                primerempleo.setNumero_exterior(oo[5].toString());
                                primerempleo.setNumero_interior("");
                                primerempleo.setColonia(c1em.getNombre());
                                primerempleo.setMunicipio(m1em.getNombre());
                                primerempleo.setEstado(e1em.getNombre());
                            }
                            if(i==1){
                                CatalogosMenuPK menuge2 = new CatalogosMenuPK("giro_empresa", Integer.parseInt(oo[15].toString()));
                                CatalogoMenus cm2em = em.find(CatalogoMenus.class, menuge2);
                                Colonias c2em = em.find(Colonias.class,oo[6]);
                                Municipios m2em = em.find(Municipios.class, c2em.getIdmunicipio());
                                Estados e2em = em.find(Estados.class, m2em.getIdestado());
                                segundoempleo.setOcupacion(oo[9].toString());
                                segundoempleo.setPuesto(oo[11].toString());
                                segundoempleo.setTelefono(oo[7].toString());
                                segundoempleo.setNombre_empresa(oo[3].toString());
                                System.out.println("pasooooooooooooooooooooooooo empleos" + cal_edad((Date) oo[10]));
                                segundoempleo.setAntiguedad(String.valueOf(cal_edad((Date) oo[10])));
                                segundoempleo.setGiro(cm2em.getDescripcion());
                                segundoempleo.setCodigo_postal(c2em.getCodigopostal());
                                segundoempleo.setCalle(oo[4].toString());
                                segundoempleo.setNumero_exterior(oo[5].toString());
                                segundoempleo.setNumero_interior("");
                                segundoempleo.setColonia(c2em.getNombre());
                                segundoempleo.setMunicipio(m2em.getNombre());
                                segundoempleo.setEstado(e2em.getNombre());
                            }
                        }
                        //System.out.println("pasooooooooooooooooooooooooo empleos");
                        TrabajoPK trPK = new TrabajoPK(persona.getPersonasPK().getIdorigen(),
                                                       persona.getPersonasPK().getIdgrupo(), 
                                                       persona.getPersonasPK().getIdsocio(), cons_tr_ac);
                        Trabajo tr = em.find(Trabajo.class,trPK);
                        System.out.println("puestooooooooooooooo: " + tr.getPuesto());
                        if(tr.getPuesto().toUpperCase().contains("JUBILADO")){
                            data.setJubilado("1");
                        }else{
                            data.setJubilado("0");
                        }
                        if(tr.getFechaingreso() == null) {
                            data.setFecha_ingreso_laboral("");
                        } else {
                            data.setFecha_ingreso_laboral(dateToString(tr.getFechaingreso())); 
                        }
                        data.setIngresos_mensuales(tr.getIng_mensual_neto().toString());
                        //Leemos colonias,municipio,estado para sacar datos personales de direccion
                        Colonias c=em.find(Colonias.class,persona.getIdcolonia());
                        Municipios mn=em.find(Municipios.class,c.getIdmunicipio());
                        Estados e=em.find(Estados.class,mn.getIdestado());
                        data.setEstado(e.getNombre());
                        data.setCiudad(mn.getNombre());
                        data.setDireccion(persona.getCalle() + " " + persona.getNumeroext());
                        data.setCodigo_postal(c.getCodigopostal());

                        if (socioeconomicos.getPropietariovivienda() != null){
                            data.setPropiedad_vivienda(socioeconomicos.getPropietariovivienda());}
                        else {data.setPropiedad_vivienda("");}
                        data.setEmail(persona.getEmail());
                        CatalogosMenuPK menuGS = new CatalogosMenuPK("grado_estudios",persona.getGradoEstudios());
                        CatalogoMenus cmge = em.find(CatalogoMenus.class, menuGS);
                        data.setUltimo_estudio_cursado(cmge.getDescripcion());
                        data.setTelefono_auxiliar(persona.getTelefono());
                        if(socioeconomicos.getFechahabitacion() == null) {
                           data.setAntiguedad_domicilio("");
                        } else {
                            data.setAntiguedad_domicilio(String.valueOf(restaFechas(socioeconomicos.getFechahabitacion()))); 
                        }
                        ReferenciasPK repk = new ReferenciasPK(a.getIdorigen(), a.getIdgrupo(), a.getIdsocio(), 1);
                        Referencias ref = em.find(Referencias.class,repk);
                        if(ref != null) {
                            String oc = String.format("%06d",ref.getIdorigenr());
                            String gc = String.format("%02d",ref.getIdgrupor());
                            String sc = String.format("%06d",ref.getIdsocior());
                            data.setNum_socio_conyugue(oc+gc+sc);
                        } else {data.setNum_socio_conyugue("");}
                        data.setCant_hijos(String.valueOf(socioeconomicos.getDependientes_menores()));
                        CatalogosMenuPK menuge = new CatalogosMenuPK("giro_empresa", tr.getGiro_empresa());
                        CatalogoMenus cmgm = em.find(CatalogoMenus.class, menuge);
                        data.setRubro_laboral(cmgm.getDescripcion());
                        data.setTelefono_trabajo(tr.getTelefono());
                        //data.setMonto_maximo_a_prestar("NO DATO");
                        if(socioeconomicos.getCuenta() != null){data.setNumero_cuenta(socioeconomicos.getCuenta());}
                        else {data.setNumero_cuenta("");}
                        data.setEs_socio_comercial("NO DATO");
                        comercioDTO comercio = new comercioDTO();
                        comercio.setGiro("NO DATO");
                        comercio.setFecha_comienzo("NO DATO");
                        comercio.setDomicilio("NO DATO");
                        comercio.setTelefono("NO DATO");
                        comercio.setIngreso_mensual("NO DATO");
                        comercio.setOtros_ingresos("NO DATO");
                        comercio.setFuente_otros_ingresos("NO DATO");
                        data.setComercio(comercio);
                        data.setFuente_ingresos_fijos(tr.getPuesto());
                        data.setMonto_ingresos_fijos(String.valueOf(tr.getIng_mensual_neto()));
                        data.setFuente_ingresos_variables("NO DATO");
                        data.setMonto_ingresos_variables(String.valueOf(socioeconomicos.getIngresosextraordinarios()));
                        if(socioeconomicos.getGastos_tipo1() != null) {
                            data.setGastos_alimentacion(String.valueOf(socioeconomicos.getGastos_tipo1()));}
                        else{data.setGastos_alimentacion("");}
                        if(socioeconomicos.getGastos_tipo2()!= null) {
                            data.setGastos_pagos_servicios(String.valueOf(socioeconomicos.getGastos_tipo2()));}
                        else{data.setGastos_pagos_servicios("");}
                        referenciasDTO referencias = new referenciasDTO();
                        referencias.setNombre("NO DATO");
                        referencias.setDireccion("NO DATO");
                        referencias.setParentesco("NO DATO");
                        referencias.setTelefono("NO DATO");
                        data.setReferencias(referencias);
                        
                        data.setPrimer_empleo(primerempleo);
                        data.setSegundo_empleo(segundoempleo);
                        
                        data.setFecha_ingreso_caja(String.valueOf(persona.getFechaingreso()));
                        NegociopropioPK ngPK = new NegociopropioPK(a.getIdorigen(), a.getIdgrupo(),a.getIdsocio());
                        Negociopropio np = em.find(Negociopropio.class,ngPK);
                        negocioDTO negocio = new negocioDTO();
                        if(np != null){ negocio.setIngresos(String.valueOf(np.getUtilidad_mens()));
                                        negocio.setCompras("NO DATO");
                                        negocio.setPago_sueldos("NO DATO");
                                        negocio.setPago_renta("NO DATO");
                                        negocio.setPago_creditos("NO DATO");
                                        negocio.setOtros("NO DATO");
                                        negocio.setTotal_negocio("NO DATO");
                                        negocio.setHorario_dias_laborables("NO DATO");
                                        negocio.setDomicilio(np.getCalle() + " " + np.getNumeroext());
                                        negocio.setFuentes_otros_negocios("NO DATO"); }
                        else{ negocio.setIngresos("");
                              negocio.setCompras("NO DATO");
                              negocio.setPago_sueldos("NO DATO");
                              negocio.setPago_renta("NO DATO");
                              negocio.setPago_creditos("NO DATO");
                              negocio.setOtros("NO DATO");
                              negocio.setTotal_negocio("NO DATO");
                              negocio.setHorario_dias_laborables("NO DATO");
                              negocio.setDomicilio("");
                              negocio.setFuentes_otros_negocios("NO DATO"); }
                        data.setNegocio(negocio);
                        data.setTotal_ingresos(String.valueOf(socioeconomicos.getIngresosordinarios()+socioeconomicos.getIngresosextraordinarios()));
                        data.setOtros_ingresos(String.valueOf(socioeconomicos.getIngresosextraordinarios()));
                        data.setFuentes_otros_ingresos("NO DATO");
                        
                        gastosDTO gastos = new gastosDTO();
                        gastos.setAlimentacion(String.valueOf(socioeconomicos.getGastos_tipo1()));
                        gastos.setVestido_calzado("NO DATO");
                        gastos.setServicios_vivienda(String.valueOf(socioeconomicos.getGastos_tipo3()));
                        gastos.setTransporte(String.valueOf(socioeconomicos.getGastos_tipo2()));
                        gastos.setEscuela("NO DATO");
                        Integer gt6 = socioeconomicos.getGastos_tipo6();
                        Integer gt4 = socioeconomicos.getGastos_tipo4();
                        if(gt6 == null){ gt6 = 0; }
                        if(gt4 == null){ gt4 = 0; }
                        gastos.setDeudas(String.valueOf(gt6 + gt4));
                        gastos.setTotal_gastos(String.valueOf(socioeconomicos.getGastosordinarios()));
                        data.setGastos(gastos);
                        
                        propiedadesDTO propiedades = new propiedadesDTO();
                        List<propiedadesDTO> listaP = new ArrayList<>();
                        listaP.add(propiedades);
                        propiedades.setValor("NO DATO");
                        propiedades.setAdeudo("NO DATO");
                        propiedades.setSaldo("NO DATO");
                        propiedades.setUbicacion("NO DATO");
                        data.setPropiedades(listaP);
                        
                        data.setTotal_valor_propiedades("NO DATO");
                        
                        conyugueDTO conyugue = new conyugueDTO();
                        if(data.getNum_socio_conyugue() != ""){
                            System.out.println("CASAD@");
                            PersonasPK ppk = new PersonasPK(ref.getIdorigenr(), ref.getIdgrupor(), ref.getIdsocior());
                            Persona p_cony = em.find(Persona.class, ppk);
                            String trab_cony = "SELECT * FROM trabajo WHERE idorigen = "+ ref.getIdorigenr()
                                        + " AND idgrupo = " + ref.getIdgrupor()
                                        + " AND idsocio = " + ref.getIdsocior()
                                        + " AND fechasalida IS NULL ORDER BY consecutivo DESC limit 1";
                            System.out.println("QUERY TRABAJO CONYUGUE: " + trab_cony);
                            Query query_con = em.createNativeQuery(trab_cony);
                            List<Object[]> tra_cony = query_con.getResultList();
                            Object[] oo_con = tra_cony.get(0);
                            int cons_tr_con = (int) oo_con[18]; ///////////////consecutivo trabajo conyugue
                            System.out.println("Consecutivo Trabajo Conyugue: " + cons_tr_con);
                            TrabajoPK tcPK = new TrabajoPK(ref.getIdorigenr(), ref.getIdgrupor(), ref.getIdsocior(), cons_tr_con);
                            Trabajo tr_con = em.find(Trabajo.class,tcPK);
                            Colonias co_con = em.find(Colonias.class,p_cony.getIdcolonia());
                            Municipios mu_con = em.find(Municipios.class, co_con.getIdmunicipio());
                            Estados es_con = em.find(Estados.class, mu_con.getIdestado());
                            conyugue.setEdad(String.valueOf(cal_edad(p_cony.getFechanacimiento())));
                            conyugue.setDireccion(p_cony.getCalle() + " " + p_cony.getNumeroext());
                            if (tr_con.getOcupacion() != null) { conyugue.setOcupacion(tr_con.getOcupacion()); } else { conyugue.setOcupacion(" "); }
                            conyugue.setCp(co_con.getCodigopostal());
                            conyugue.setCiudad(mu_con.getNombre());
                            conyugue.setEstado(es_con.getNombre());
                            conyugue.setLugar_trabajo(tr_con.getNombre());
                            if (tr_con.getFechaingreso() == null) {
                                conyugue.setAntiguedad("");
                            } else {
                                conyugue.setAntiguedad(String.valueOf(restaFechas(tr_con.getFechaingreso())));
                            }
                            if (tr_con.getCalle() != null) { conyugue.setDomicilio_empleo(tr_con.getCalle() + " " + tr_con.getNumero()); }
                            else { conyugue.setDomicilio_empleo(""); }
                            if (tr_con.getTelefono() != null) { conyugue.setTelefono_empleo(tr_con.getTelefono()); } 
                            else { conyugue.setTelefono_empleo(""); }
                            conyugue.setHistorial("NO DATO");
                        }
                        data.setConyugue(conyugue);
                        
                        /*avalDTO aval = new avalDTO();
                        aval.setNombre("NO DATO");
                        aval.setDireccion("NO DATO");
                        aval.setCiudad("NO DATO");
                        data.setAval(aval);
                        codeudorDTO codeudor = new codeudorDTO();
                        codeudor.setCiudad("NO DATO");
                        codeudor.setDireccion("NO DATO");
                        data.setCodeudor(codeudor);*/
                        
                        List<referenciasPersonalesDTO> listaRP = new ArrayList<>();
                        String Refe_Per = "SELECT * FROM referencias WHERE idorigen = " + persona.getPersonasPK().getIdorigen()
                                                + " AND idgrupo = " + persona.getPersonasPK().getIdgrupo() 
                                                + " AND idsocio = " + persona.getPersonasPK().getIdsocio()
                                                + " AND tiporeferencia = 3";
                        System.out.println("QUERY REFERENCIAS PERSONALES: " + Refe_Per);
                        Query query_ref_per = em.createNativeQuery(Refe_Per);
                        List<Object[]> lista_rf_per = query_ref_per.getResultList();
                        for(int x=0;x<lista_rf_per.size();x++) {
                            referenciasPersonalesDTO referencias_personales = new referenciasPersonalesDTO();
                            Object[] o_rfp = lista_rf_per.get(x);
                            PersonasPK per_ref = new PersonasPK((int) o_rfp[5], (int) o_rfp[6], (int) o_rfp[7]);
                            Persona inf_ref = em.find(Persona.class, per_ref);
                            
                            referencias_personales.setNombre(inf_ref.getNombre() + " " + inf_ref.getAppaterno() + " " + inf_ref.getApmaterno());
                            referencias_personales.setDireccion(inf_ref.getCalle() + " " + inf_ref.getNumeroext());
                            referencias_personales.setParentesco(String.valueOf(o_rfp[4]));
                            referencias_personales.setTelefono(inf_ref.getTelefono());
                            
                            listaRP.add(referencias_personales);
                        }
                        data.setReferencias_personales(listaRP);
                        
                        referenciasLaboralesDTO referencias_laborales = new referenciasLaboralesDTO();
                        referencias_laborales.setNombre("NO DATO");
                        referencias_laborales.setDireccion("NO DATO");
                        referencias_laborales.setTiempo_conocerlo("NO DATO");
                        referencias_laborales.setTelefono("NO DATO");
                        data.setReferencias_laborales(referencias_laborales);
                        
                        relacionesSociosDTO relaciones_socios = new relacionesSociosDTO();
                        List<relacionesSociosDTO> listaRS = new ArrayList<>();
                        listaRS.add(relaciones_socios);                        
                        relaciones_socios.setNombre("NO DATO");
                        relaciones_socios.setNumero_socio("NO DATO");
                        relaciones_socios.setParentesco("NO DATO");
                        data.setRelaciones_socios(listaRS);
                        
                        /*data.setReca_completo("NO DATO");
                        data.setReca_recortado("NO DATO");*/
                        data.setOgs(o+g+s);
                        /*data.setOpa("NO DATO");
                        data.setCat("NO DATO");
                        data.setNumero_producto("NO DATO");
                        data.setClasificacion_cartera("NO DATO");
                        data.setId_solicitud_siscore("NO DATO");
                        data.setFolio_prestamo("NO DATO");
                        data.setNumero_folio_poliza("NO DATO");
                        data.setNumero_pagare("NO DATO");
                        data.setFecha_vencimiento_pagare("NO DATO");
                        data.setResumen_calificacion("NO DATO");
                        data.setRegimen_patrimonial("NO DATO");*/
                        data.setNumero_dependientes(String.valueOf(socioeconomicos.getDependientes() + socioeconomicos.getDependientes_menores()));
                        data.setTelefono_recados(persona.getTelefonorecados());
                        String con_aho = "SELECT * FROM auxiliares WHERE idorigen=" + a.getIdorigen()
                                       + " AND idgrupo=" + a.getIdgrupo()
                                       + " AND idsocio=" + a.getIdsocio()
                                       + " AND idproducto=" + 110;
                        System.out.println("Cosulta Ahorro: " + con_aho);
                        Query queryAh = em.createNativeQuery(con_aho, Auxiliares.class);
                        Auxiliares aux_ah = (Auxiliares) queryAh.getSingleResult();
                        data.setMonto_ahorro(String.valueOf(aux_ah.getSaldo()));
                        /*data.setProteccion_ahorro_prestamo("NO DATO");
                        data.setGarantia_liquida("NO DATO");
                        data.setTipo_garantia("NO DATO");
                        data.setDeposito_garantia_letras("NO DATO");*/
                        data.setAntiguedad_socio(String.valueOf(cal_edad(persona.getFechaingreso())));
                        data.setParte_social(String.valueOf(a.getSaldo()));
                        data.setFideicomiso("NO DATO");
                        data.setHistorial_cooperativa("NO DATO");
                        data.setLinea_credito("NO DATO");
                        data.setLinea_credito_letras("NO DATO");
                        data.setAseguradora("NO DATO");
                        data.setClausulas("NO DATO");
                        data.setModalidad_pago("NO DATO");
                        data.setTipo_operacion("NO DATO");
                        data.setDatos_del_poder("NO DATO");
                        data.setDisponibilidad("NO DATO");
                        data.setPorcentaje_capacidad("NO DATO");
                        data.setIdauxiliar("NO DATO");
                        data.setIdorigenp("NO DATO");
                        CatalogosMenuPK menusex = new CatalogosMenuPK("sexo", Integer.parseInt(String.valueOf(persona.getSexo())));
                        CatalogoMenus cmsex = em.find(CatalogoMenus.class, menusex);
                        data.setSexo(cmsex.getDescripcion());
                        System.out.println("TERMINOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
                        
                    }
                    
                }else{
                    data.setEs_socio("2");
                }
            } else {
                data.setEs_socio("Tabla no esta configurada");
            }
            info.setData(data);
        } catch (Exception e) {
            em.close();
            e.printStackTrace();
            System.out.println("ErrorProducdio:"+e.getMessage());
            return data;
        }
        em.close();
        return data;
    }

    //Metodo para saber si la personas realmente existe en la base de datos
    public Persona buscaPersona(String documento, String numeroDocumento) {
        EntityManager em = emf.createEntityManager();
        String consulta = "SELECT * FROM personas WHERE " + documento + "='" + numeroDocumento + "'";
        String m = "";
        Persona p = null;
        try {
            System.out.println("Consulta:" + consulta);
            Query query = em.createNativeQuery(consulta, Persona.class);
            p = (Persona) query.getSingleResult();
            if (p != null) {
                m = "existe";
            } else {
                m = "No existe";
            }
            em.close();
        } catch (Exception e) {
            m = "No existe";
            System.out.println("Error en buscar persona:" + e.getMessage());
            em.close();
        }
        System.out.println("m:" + m);
        return p;
    }

    public String dateToString(Date fechac){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String fechaDate = null;

        try {
            fechaDate = formato.format(fechac);
        } catch (Exception ex) {
            System.out.println("Error fecha:" + ex.getMessage());
        }
        System.out.println("fechaDate:" + fechaDate);
        return fechaDate.replace("/","-");
    }
    
    //Metodo para calcular cuantos meses hay entre 2 fechas
    public int restaFechas(Date fecha){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date hoy = new Date();
        String fecha_hoy = sdf.format(hoy);
        String fechaBase = sdf.format(fecha);

        String añoH = fecha_hoy.substring(0,4);
        String añoB = fechaBase.substring(0,4);
        String mesH = fecha_hoy.substring(5,7);
        String mesB = fechaBase.substring(5,7);

        int Años = Integer.parseInt(añoH) - Integer.parseInt(añoB);
        int Meses = Años * 12 + Integer.parseInt(mesH) - Integer.parseInt(mesB);

        System.out.println("TOTAL MESES:" + Meses);
        return Meses;
    }
    
    //Metodo para calcular edad
    public int cal_edad(Date fecha_nac){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaNac = sdf.format(fecha_nac);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(fechaNac, formatter);

        Period edad = Period.between(fechaNacimiento, LocalDate.now());

        System.out.println("AÑOS CUMPLIDOS: " + edad.getYears() + " Años " + edad.getMonths() + " Meses " + edad.getDays() + " Dias");

        return edad.getYears();
    }

    public void cerrar() {
        emf.close();
    }

}
