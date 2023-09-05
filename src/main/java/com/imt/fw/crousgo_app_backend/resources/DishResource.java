package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.Dish;
import com.imt.fw.crousgo_app_backend.repositories.DishRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.validation.constraints.NotNull;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@Path("dishes")
public class DishResource {

    @Inject
    private DishRepository dishRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dish> getDish() {
        List<Dish> dishes = dishRepository.findAll();
        if (dishes.isEmpty()) {
            throw new WebApplicationException("No dishes found", 404);
        }
        return dishes;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDish(@NotNull Dish dish) {
        try {
            dishRepository.save(dish);
            return Response.status(201).entity("Dish created").build();
        } catch (Exception e) {
            throw new WebApplicationException("Dish could not be created", 500);
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteDish(@PathParam("id") Long id) {
        if (!dishRepository.existsById(id)) {
            throw new WebApplicationException("Dish not found", 404);
        }
        try {
            dishRepository.deleteById(id);
            return Response.status(200).entity("Dish deleted").build();
        } catch (Exception e) {
            throw new WebApplicationException("Dish could not be deleted", 500);
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDish(@PathParam("id") Long id, Dish dish) {
        if (!dishRepository.existsById(id)) {
            throw new WebApplicationException("Dish not found", 404);
        }
        try {
            dishRepository.save(dish);
            return Response.status(200).entity("Dish updated").build();
        } catch (Exception e) {
            throw new WebApplicationException("Dish could not be updated", 500);
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Dish getDishById(@PathParam("id") Long id) {
        Optional<Dish> dish = dishRepository.findById(id);
        return dish.orElseThrow(() -> new WebApplicationException("Dish not found", 404));
    }
}
