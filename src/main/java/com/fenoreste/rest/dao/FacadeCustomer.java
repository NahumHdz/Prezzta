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
import com.fenoreste.rest.entidades.Trabajos_Socio;
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
    
    public InfoClienteDTO clientInfo(Persona persona) {
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
                        TrabajoPK trPK=new TrabajoPK(a.getIdorigen(), a.getIdgrupo(),a.getIdsocio());
                        Trabajo tr=em.find(Trabajo.class,trPK);
                        if(tr.getPuesto().toUpperCase().contains("JUBILADO")){
                            data.setJubilado("1");
                        }else{
                            data.setJubilado("0");
                        }
                        data.setFecha_ingreso_laboral(dateToString(tr.getFechaingreso()));
                        data.setIngresos_mensuales(tr.getIng_mensual_neto().toString());
                        //Leemos colonias,municipio,estado para sacar datos personales de direccion
                        Colonias c=em.find(Colonias.class,persona.getIdcolonia());
                        Municipios mn=em.find(Municipios.class,c.getIdmunicipio());
                        Estados e=em.find(Estados.class,mn.getIdestado());
                        data.setEstado(e.getNombre());
                        data.setCiudad(mn.getNombre());
                        data.setDireccion(persona.getCalle() + " " + persona.getNumeroext());
                        data.setCodigo_postal(c.getCodigopostal());
                        CatalogosMenuPK menuPK=new CatalogosMenuPK("estatusvivienda",socioeconomicos.getEstatusvivienda());
                        CatalogoMenus mne=em.find(CatalogoMenus.class, menuPK);

                        if (socioeconomicos.getPropietariovivienda() != null){
                            data.setPropiedad_vivienda(socioeconomicos.getPropietariovivienda());}
                        else {data.setPropiedad_vivienda("");}
                        data.setEmail(persona.getEmail());
                        CatalogosMenuPK menuGS = new CatalogosMenuPK("grado_estudios",persona.getGradoEstudios());
                        CatalogoMenus cmge = em.find(CatalogoMenus.class, menuGS);
                        data.setUltimo_estudio_cursado(cmge.getDescripcion());
                        data.setTelefono_auxiliar(persona.getTelefono());
                        data.setAntiguedad_domicilio(String.valueOf(restaFechas(socioeconomicos.getFechahabitacion())));
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
                        if(socioeconomicos.getCuenta() != null){data.setNumero_cuenta(socioeconomicos.getCuenta());}
                        else {data.setNumero_cuenta("");}
                        data.setEs_socio_comercial("0");
                        data.setComercio_giro("");
                        data.setComercio_fecha_comienzo("");
                        data.setComercio_domicilio("");
                        data.setComercio_telefono("");
                        data.setComercio_ingreso_mensual("");
                        data.setComercio_otros_ingresos("");
                        data.setComercio_fuente_otros_ingresos("");
                        data.setFuente_ingresos_fijos(tr.getPuesto());
                        data.setMonto_ingresos_fijos(String.valueOf(tr.getIng_mensual_neto()));
                        if(socioeconomicos.getGastos_tipo1() != null) {
                            data.setGastos_alimentacion(String.valueOf(socioeconomicos.getGastos_tipo1()));}
                        else{data.setGastos_alimentacion("");}
                        if(socioeconomicos.getGastos_tipo2()!= null) {
                            data.setGastos_pagos_servicios(String.valueOf(socioeconomicos.getGastos_tipo2()));}
                        else{data.setGastos_pagos_servicios("");}
                        data.setFecha_ingreso_caja(String.valueOf(persona.getFechaingreso()));
                        NegociopropioPK ngPK = new NegociopropioPK(a.getIdorigen(), a.getIdgrupo(),a.getIdsocio());
                        Negociopropio np = em.find(Negociopropio.class,ngPK);
                        if(np != null){ data.setNegocio_ingresos(String.valueOf(np.getUtilidad_mens()));
                                        data.setNegocio_compras("");
                                        data.setNegocio_pago_sueldos("");
                                        data.setNegocio_pago_renta("");
                                        data.setNegocio_pago_creditos("");
                                        data.setNegocio_otros("");
                                        data.setNegocio_total_negocio("");
                                        data.setNegocio_horario_dias_laborables("");
                                        data.setNegocio_domicilio(np.getCalle() + " " + np.getNumeroext());
                                        data.setNegocio_fuentes_otros_negocios(""); }
                        else{   data.setNegocio_ingresos("");
                                data.setNegocio_compras("");
                                data.setNegocio_pago_sueldos("");
                                data.setNegocio_pago_renta("");
                                data.setNegocio_pago_creditos("");
                                data.setNegocio_otros("");
                                data.setNegocio_total_negocio("");
                                data.setNegocio_horario_dias_laborables("");
                                data.setNegocio_domicilio("");
                                data.setNegocio_fuentes_otros_negocios(""); }
                        data.setGatos_alimentacion(String.valueOf(socioeconomicos.getGastos_tipo1()));
                        data.setGatos_vestido_calzado("");
                        data.setGatos_servicios_vivienda(String.valueOf(socioeconomicos.getGastos_tipo3()));
                        data.setGatos_transporte(String.valueOf(socioeconomicos.getGastos_tipo2()));
                        data.setGatos_escuela("");
                        Integer gt6 = socioeconomicos.getGastos_tipo6();
                        Integer gt4 = socioeconomicos.getGastos_tipo4();
                        if(gt6 == null){ gt6 = 0; }
                        if(gt4 == null){ gt4 = 0; }
                        data.setGatos_deudas(String.valueOf(gt6 + gt4));
                        data.setGatos_total_gastos(String.valueOf(socioeconomicos.getGastosordinarios()));
                        if(data.getNum_socio_conyugue() != ""){
                            System.out.println("CASAD@");
                            PersonasPK ppk = new PersonasPK(ref.getIdorigenr(), ref.getIdgrupor(), ref.getIdsocior());
                            Persona p_cony = em.find(Persona.class, ppk);
                            TrabajoPK tcPK = new TrabajoPK(ref.getIdorigenr(), ref.getIdgrupor(), ref.getIdsocior());
                            Trabajo tr_con = em.find(Trabajo.class,tcPK);
                            Colonias co_con = em.find(Colonias.class,p_cony.getIdcolonia());
                            Municipios mu_con = em.find(Municipios.class, co_con.getIdmunicipio());
                            Estados es_con = em.find(Estados.class, mu_con.getIdestado());
                            data.setConyugue_edad(String.valueOf(cal_edad(p_cony.getFechanacimiento())));
                            data.setConyugue_direccion(p_cony.getCalle() + " " + p_cony.getNumeroext());
                            data.setConyugue_ocupacion(tr_con.getOcupacion());
                            data.setConyugue_cp(co_con.getCodigopostal());
                            data.setConyugue_ciudad(mu_con.getNombre());
                            data.setConyugue_estado(es_con.getNombre());
                            data.setConyugue_lugar_trabajo(tr_con.getNombre());
                            data.setConyugue_antiguedad("");
                            data.setConyugue_domicilio_empleo(tr_con.getCalle() + " " + tr_con.getNumero());
                            data.setConyugue_telefono_empleo(tr_con.getTelefono());
                            data.setConyugue_historial("");
                            System.out.println("EDAD CONYUGUE: " + cal_edad(p_cony.getFechanacimiento()));
                        }else{System.out.println("NO ES CASAD@");}
                        data.setOgs(o+g+s);
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
                        data.setAntiguedad_socio(String.valueOf(cal_edad(persona.getFechaingreso())));
                        data.setParte_social(String.valueOf(a.getSaldo()));

                        CatalogosMenuPK menusex = new CatalogosMenuPK("sexo", Integer.parseInt(String.valueOf(persona.getSexo())));
                        CatalogoMenus cmsex = em.find(CatalogoMenus.class, menusex);
                        data.setSexo(cmsex.getDescripcion());
                        System.out.println("EDAD SOCIO: " + cal_edad(persona.getFechanacimiento()));

                        System.out.println("PPPPPPAAAAAAAASSSSSSSOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");

                        /*try {
                            em.clear();
                         String trabajos = "SELECT * FROM trabajo WHERE idorigen = "+ persona.getPersonasPK().getIdorigen()
                                        + " AND idgrupo = " + persona.getPersonasPK().getIdgrupo() 
                                        + " AND idsocio = " + persona.getPersonasPK().getIdsocio()+" ORDER BY consecutivo DESC";
                        System.out.println("Consulta: " + trabajos);
                        List<Trabajos_Socio>Lista = new ArrayList<Trabajos_Socio>();
                        Query query = em.createNativeQuery(trabajos,Trabajos_Socio.class);
                        System.out.println("QUERY: " + query);
                        Lista = query.getResultList();
                        Trabajos_Socio ty = Lista.get(1);
                        
                        System.out.println("ListaTrabajo: " + ty.getNombre());

                        for(int i=0;i<Lista.size();i++){
                            Trabajos_Socio trr = Lista.get(i);
                            System.out.println("Trr: " + trr);
                        }   
                        } catch (Exception ex) {
                            System.out.println("Error");
                        }*/

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
            return info;
        }
        em.close();
        return info;
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
