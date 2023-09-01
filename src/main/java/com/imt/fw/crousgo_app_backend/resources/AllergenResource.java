package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.Allergen;
import com.imt.fw.crousgo_app_backend.repositories.AllergenRepository;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Path("allergens")

public class AllergenResource {

    @Autowired
    private AllergenRepository allergenRepository;

    @GET
    @Produces(value = "application/json")
    public List<Allergen> getAllergen() {
        return allergenRepository.findAll();
    }
    @POST
    @Consumes("application/json")
    public void createAllergen(@NotNull @RequestBody Allergen allergen){
        allergenRepository.save(allergen);
    }

}
