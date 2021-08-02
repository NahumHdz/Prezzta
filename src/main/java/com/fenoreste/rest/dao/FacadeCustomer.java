package com.fenoreste.rest.dao;

import com.fenoreste.rest.entidades.Persona;
import com.fenoreste.rest.Util.AbstractFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import com.fenoreste.rest.ResponseDTO.*;
import com.fenoreste.rest.entidades.Auxiliares;
import com.fenoreste.rest.entidades.CatalogosMenuPK;
import com.fenoreste.rest.entidades.Colonias;
import com.fenoreste.rest.entidades.Estados;
import com.fenoreste.rest.entidades.Municipios;
import com.fenoreste.rest.entidades.Socioeconomicos;
import com.fenoreste.rest.entidades.SocioeconomicosPK;
import com.fenoreste.rest.entidades.Tablas;
import com.fenoreste.rest.entidades.TablasPK;
import com.fenoreste.rest.entidades.Trabajo;
import com.fenoreste.rest.entidades.TrabajoPK;
import java.text.SimpleDateFormat;
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
                        data.setDireccion(c.getIdcolonia()+","+persona.getNumeroext()+","+persona.getNumeroint());
                        data.setCodigo_postal(c.getCodigopostal());
                        CatalogosMenuPK menuPK=new CatalogosMenuPK("estatusvivienda",socioeconomicos.getEstatusvivienda());
                        
                        
                        
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
    public void cerrar() {
        emf.close();
    }
    
}
