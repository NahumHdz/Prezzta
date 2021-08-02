/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.RESTservices;

import com.fenoreste.rest.ResponseDTO.InfoClienteDTO;
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
        try {
            //Buscamos si la persona que se esta ingresando con esa CURP realment existe en la entidad
            Persona p = dao.buscaPersona(tipo_documento, numero_documento);
            if (p != null) {
                InfoClienteDTO info = dao.clientInfo(p);
                System.out.println("info:" + info);
            } else {
                JsonResponse.put("Error", "Socio no existe");
            }

        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
        } finally {
            dao.cerrar();
        }
        return Response.status(Response.Status.OK).entity(JsonResponse).build();

    }
}
