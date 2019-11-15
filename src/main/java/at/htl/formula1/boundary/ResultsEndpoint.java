package at.htl.formula1.boundary;

import at.htl.formula1.entity.Driver;
import at.htl.formula1.entity.Result;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


public class ResultsEndpoint {

    @PersistenceContext
    EntityManager em;

    /**
     * @param name als QueryParam einzulesen
     * @return JsonObject
     */
    @GET @Path("name") @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getPointsSumOfDriver(@QueryParam("name") String name) {
        return null;
    }

    /**
     * @param id des Rennens
     * @return
     */
    @GET @Path("{id}") @Produces(MediaType.APPLICATION_JSON)
    public Response findWinnerOfRace(@PathParam("id") long id) {
        //return em.find(Result.class, id);
        return null;
    }


}
