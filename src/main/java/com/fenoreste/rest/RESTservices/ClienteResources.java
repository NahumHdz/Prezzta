/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.RESTservices;

import com.fenoreste.rest.ResponseDTO.InfoClienteDTO;
import com.fenoreste.rest.ResponseDTO.dataDTO;
import com.fenoreste.rest.dao.CustomerDAO;
import com.fenoreste.rest.entidades.Persona;
import com.github.cliftonlabs.json_simple.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

/**
 *
 * @author Elliot
 */
@Path("/api")
public class ClienteResources {

    @POST
    @Path("/cliente")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public Response cliente(String request) {
        System.out.println("Request:"+request);
        JSONObject jsonRequest_ = new JSONObject(request);
        //Leer request
        int tipo_documento_id = 0;
        String tipo_documento = "";
        String numero_documento = "";
        //leemos el request json
        try {
            tipo_documento_id = jsonRequest_.getInt("tipo_documento_id");
            tipo_documento = jsonRequest_.getString("tipo_documento");
            numero_documento = jsonRequest_.getString("numero_documento");

        } catch (Exception e) {
            System.out.println("Error producido al llenar jsonRequest:" + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
        //Si se leyo bien el request pasamos a hacer y extraer todos los datos que debe responder
        CustomerDAO dao = new CustomerDAO();
        JsonObject JsonResponse = new JsonObject();
        InfoClienteDTO info=null;
        dataDTO dto=null;
        try {
            //Buscamos si la persona que se esta ingresando con esa CURP realment existe en la entidad            
            Persona p = dao.buscaPersona(tipo_documento, numero_documento);
            if (p != null) {
                 dto= dao.clientInfo(p);
                System.out.println("info:" + info);
            } else {
                JsonResponse.put("Error", "Socio no existe");
            }

            JsonResponse.put("data",dto);

        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
        } finally {
            dao.cerrar();
        }
        return Response.status(Response.Status.OK).entity(JsonResponse).build();
    }
    
    @POST
    @Path("/datos_credito")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public Response datos_credito(String request) {
        System.out.println("Request: " + request);
        JSONObject jsonRequest = new JSONObject(request);
        
        String numero_socio = "";
        Double monto_solicitado = 0.0;
        int plazo_solicitado = 0;
        String producto_solicitado = "";
        
        try {
            numero_socio = jsonRequest.getString("numero_socio");
            monto_solicitado = jsonRequest.getDouble("monto_solicitado");
            plazo_solicitado = jsonRequest.getInt("plazo_solicitado");
            producto_solicitado = jsonRequest.getString("producto_solicitado");
            System.out.println("JSON Correcto");
        } catch (Exception e) {
            System.out.println("Error JSON: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
        return null;
    }
    
}
