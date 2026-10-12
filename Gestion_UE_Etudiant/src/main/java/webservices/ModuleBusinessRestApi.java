package webservices;
import entities.Module;
import entities.UniteEnseignement;
import metiers.ModuleBusiness;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/module")
public class ModuleBusinessRestApi {

    static ModuleBusiness helper = new ModuleBusiness();
    static UniteEnseignementBusiness ueHelper = new UniteEnseignementBusiness();

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllModules() {
        return Response
                .status(200)
                .entity(helper.getAllModules())
                .build();
    }
    // add a new UE
    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createModule(Module module) {
        if (helper.addModule(module)) {
            return Response.status(201).entity("ok").build();
        } else {
            return Response.status(400).entity("error").build();
        }
    }
    @GET
    @Path("/{matricule}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModuleByMatricule(@PathParam("matricule") String matricule) {
        return Response
                .status(200)
                .entity(helper.getModuleByMatricule(matricule))
                .build();
    }

    @GET
    @Path("/type")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModulesByType(@QueryParam("type") Module.TypeModule type) {
        return Response
                .status(200)
                .entity(helper.getModulesByType(type))
                .build();
    }
    @DELETE
    @Path("/delete/{matricule}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteModule(@PathParam("matricule") String matricule) {
        if (helper.deleteModule(matricule)) {
            return Response.status(200).entity("ok").build();
        } else {
                return Response.status(400).entity("error").build();
        }
    }
}

