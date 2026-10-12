package webservices;
import entities.Module;
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
}