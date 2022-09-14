package br.com.bb.t99.rest;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.opentracing.Traced;

import br.com.bb.t99.model.Produto;
import br.com.bb.t99.services.ProdutoServices;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
//import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
@ApplicationScoped
@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
@Traced
public class ProdutoResource {
    @Inject
    ProdutoServices service;

    @GET
    @Operation(summary = "Listar Contas ",
            description = "Retorna uma lista de contas")
    @APIResponse(
            responseCode = "200",
            description = "Conta",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Produto.class, type = SchemaType.ARRAY))})
    public Response obtemUsuarios() throws Exception  {
        return Response.status(Response.Status.OK).entity(service.listarProduto()).build(); //modifiquei aqui
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Deletar produto por id",
            description = "Deletar produto por id")
    @APIResponse(
            responseCode = "200",
            description = "Produto",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Produto.class, type = SchemaType.ARRAY))})
    public Response deletarProduto(final @PathParam("id") int id) throws Exception  {
        return Response.status(Response.Status.OK).entity(service.deletarProduto(id)).build();
    }

    
}
