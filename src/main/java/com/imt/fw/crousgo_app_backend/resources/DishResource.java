package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.Dish;
import com.imt.fw.crousgo_app_backend.repositories.DishRepository;
import jakarta.validation.constraints.NotNull;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("dishes")
public class DishResource {

    @Inject
    private DishRepository dishRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dish> getDish() {
        return dishRepository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createDish(@NotNull Dish dish){
        dishRepository.save(dish);
    }

    @DELETE
    @Path("{id}")
    public void deleteDish(@PathParam("id") Long id){
        dishRepository.deleteById(id);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateDish(@PathParam("id") Long id, Dish dish){
        dishRepository.save(dish);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Dish getDishById(@PathParam("id") Long id){
        return dishRepository.findById(id).orElse(null);
    }
}
