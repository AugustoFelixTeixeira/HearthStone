/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.avaliacao.hearthstone.carta;

import br.com.avaliacao.hearthstone.carta.CartaEntity;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author b2ml
 */
@Path("/carta")
public class CartaResource {

    @Autowired
    private CartaService service;
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<CartaEntity> get() {
//        return service.
//    }
////        
//    @GET
//    @Path("{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public CartaEntity getById(@PathParam("id") int id) {
//        return ;
//    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(CartaEntity carta) {
        try {
            service.save(carta);
            return Response.status(Response.Status.CREATED).entity("").build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

}
