package at.htl.formula1.boundary;

import at.htl.formula1.entity.Driver;
import at.htl.formula1.entity.Race;
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

@Path("results")
public class ResultsEndpoint {

    @PersistenceContext
    EntityManager em;

    /**
     * @param name als QueryParam einzulesen
     * @return JsonObject
     */
    @GET @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getPointsSumOfDriver(@QueryParam("name") String name) {
        Long points;

        points = em.createNamedQuery("Result.pointSumDriver", Long.class)
                .setParameter("NAME", name)
                .getSingleResult();

        Driver driver = em.createNamedQuery("Driver.findByName", Driver.class)
                .setParameter("NAME", name)
                .getSingleResult();

        return Json.createObjectBuilder()
                .add("driver", name)
                .add("points", points)
                .build();
    }


    @GET @Path("winner/{country}") @Produces(MediaType.APPLICATION_JSON)
    public Response findWinnerOfRace(@PathParam("country") String country) {

        Driver driver = em.createNamedQuery("Result.countryOfDriver", Driver.class)
                .setParameter("COUNTRY", country)
                .getSingleResult();

        return Response.ok().build();

    }

    @GET @Path("raceswon") @Produces(MediaType.APPLICATION_JSON)
    public Response getWonRacesByTeam(@QueryParam("team") String team){

        List<Race> racesWon = em.createNamedQuery("Result.wonRacesTeam", Race.class)
                .setParameter("TEAM", team)
                .getResultList();
        return Response.ok().build();
    }




}
