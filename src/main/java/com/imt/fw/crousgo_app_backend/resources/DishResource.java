package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.Dish;
import com.imt.fw.crousgo_app_backend.repositories.DishRepository;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Path("dishes")
public class DishResource {

    @Autowired
    private DishRepository dishRepository;

    @GET
    @Produces(value = "application/json")
    public List<Dish> getDish() {
        return dishRepository.findAll();
    }

    @POST
    @Consumes("application/json")
    public void createDish(@NotNull @RequestBody Dish dish){
        dishRepository.save(dish);
    }

    @DELETE
    @Path("/{id}")
    public void deleteDish(@PathParam("id") Long id){
        dishRepository.deleteById(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public void updateDish(@PathParam("id") Long id, @NotNull @RequestBody Dish dish){
        dishRepository.save(dish);
    }

    @GET
    @Path("/{id}")
    @Produces(value = "application/json")
    public Dish getDishById(@PathParam("id") Long id){
        return dishRepository.findById(id).orElse(null);
    }
}