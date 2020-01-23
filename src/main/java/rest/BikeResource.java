package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.BikeDTO;
import dtos.BikeDTOs;
import entities.Bike;
import utils.EMF_Creator;
import facades.BikeFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

@Path("bike")
public class BikeResource {

    private static EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static final BikeFacade FACADE = BikeFacade.getFacadeExample(EMF);

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"this is a movie database\"}";
    }

    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getBikes() {
        List<Bike> Bikes = FACADE.getAllBikes();
        List<BikeDTO> BikeDto = new ArrayList();
        for (Bike b : Bikes) {
            BikeDto.add(new BikeDTO(b));
        }
        return GSON.toJson(BikeDto);

    }

    @Path("/search/{search}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String searchBikes(@PathParam("search") String make) {
        List<Bike> bikes = FACADE.searchForBike(make);
        List<BikeDTO> moviedto = new ArrayList();
        for (Bike b : bikes) {
            moviedto.add(new BikeDTO(b));
        }
        return GSON.toJson(moviedto);
    }

    @POST
    @Path("/addBike")
    
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String addMovie(@PathParam("id") int id, String movie) {
        BikeDTO toAdd = GSON.fromJson(movie, BikeDTO.class);
        Bike added = FACADE.addBike(toAdd.getMake(), toAdd.getSize(), toAdd.getGender(), toAdd.getGears(), toAdd.getDay_price());
        return GSON.toJson(new BikeDTO(added));
        
    }
}
