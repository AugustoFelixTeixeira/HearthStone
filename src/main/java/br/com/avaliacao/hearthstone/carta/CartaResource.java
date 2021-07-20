/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.avaliacao.hearthstone.carta;

import br.com.avaliacao.hearthstone.carta.CartaEntity;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author b2ml
 */
@Path("/carta")
public class CartaResource {

    @Autowired
    private CartaService service;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        try {
            List<CartaEntity> cartas = service.getAll();
            return Response.status(Response.Status.OK).entity(cartas).build();
        } catch (Exception ex) {
            JSONObject resposta = new JSONObject();
            resposta.put("erro", "Contactar um admin.");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(resposta.toString()).build();
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Optional<CartaEntity> c = service.getCartaById(id);
        try {
            if (!c.isPresent()) {
                JSONObject resposta = new JSONObject();
                resposta.put("mensagem", "Nenhuma carta encontrada com esse id: " + id);
                return Response.status(Response.Status.NOT_FOUND).entity(resposta.toString()).build();
            }

            return Response.status(Response.Status.OK).entity(c.get()).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

    @GET
    @Path("/nome/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("nome") String nome) {
        List<CartaEntity> c = service.getCartaByNome(nome);
        try {
            return Response.status(Response.Status.OK).entity(c).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

    @GET
    @Path("/tipo/{tipo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("tipo") CartaEntity.Tipo tipo) {
        List<CartaEntity> c = service.getCartaByTipo(tipo);
        try {
            return Response.status(Response.Status.OK).entity(c).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

    @GET
    @Path("/classe/{classe}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("classe") CartaEntity.Classe classe) {
        List<CartaEntity> c = service.getCartaByClasse(classe);
        try {
            return Response.status(Response.Status.OK).entity(c).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(CartaEntity carta) {
        try {
            service.save(carta);

            JSONObject resposta = new JSONObject();
            resposta.put("mensagem", "Carta cadastrada com sucesso.");

            return Response.status(Response.Status.CREATED).entity(resposta.toString()).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(service.validarCarta(carta).toString()).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        Optional<CartaEntity> c = service.getCartaById(id);
        try {
            if (!c.isPresent()) {
                JSONObject resposta = new JSONObject();
                resposta.put("mensagem", "Nenhuma carta encontrada com esse id: " + id);
                return Response.status(Response.Status.NOT_FOUND).entity(resposta.toString()).build();
            }

            service.delete(id);

            JSONObject resposta = new JSONObject();
            resposta.put("mensagem", "Carta excluida com sucesso.");

            return Response.status(Response.Status.OK).entity(resposta.toString()).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

}
