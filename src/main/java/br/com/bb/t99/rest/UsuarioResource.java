package br.com.bb.t99.rest;
import br.com.bb.t99.services.UsuarioService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.opentracing.Traced;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/hello")
@Produces(MediaType.TEXT_PLAIN)
//@Consumes(MediaType.APPLICATION_JSON)
@Traced
public class UsuarioResource {

    @Inject
    UsuarioService service;
   
    @GET
    @Operation(summary = "Exibir mensagem HELLO",
            description = "Exibir mensagem HELLO")
    public Response escreverHello() throws Exception {
        return  Response.status(Response.Status.OK).entity(UsuarioService.hello()).build();
    }

    @GET
    @Path("/{nome}")
    @Operation(summary = "Exibir mensagem HELLO",
            description = "Exibir mensagem HELLO")
    public Response escreverHelloComNome(final @PathParam("nome") String nome) throws Exception {
        return  Response.status(Response.Status.OK).entity(UsuarioService.helloComNome(nome)).build();
    }
    
    @GET
    @Path("/{nome}/horario")
    @Operation(summary = "Exibir mensagem HELLO",
            description = "Exibir mensagem HELLO")
    public Response getHoraName(final @PathParam("nome") String nome) throws Exception {
        return  Response.status(Response.Status.OK).entity(UsuarioService.getHoraName(nome)).build();
    }
    
}