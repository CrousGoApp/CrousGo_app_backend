package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.Dish;
import com.imt.fw.crousgo_app_backend.repositories.DishRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Path("dish")
public class DishResource {

    @Autowired
    private DishRepository dishRepository;

    @GET
    @Produces(value = "application/json")
    public List<Dish> getDish() {
        return dishRepository.findAll();
    }
}