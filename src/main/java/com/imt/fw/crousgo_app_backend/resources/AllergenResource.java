package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.Allergen;
import com.imt.fw.crousgo_app_backend.repositories.AllergenRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.validation.constraints.NotNull;
import jakarta.inject.Inject;

import java.util.List;

@Path("allergens")
public class AllergenResource {

    @Inject
    private AllergenRepository allergenRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Allergen> getAllergen() {
        return allergenRepository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createAllergen(@NotNull Allergen allergen){
        allergenRepository.save(allergen);
    }

    @DELETE
    @Path("/{id}")
    public void deleteAllergen(@PathParam("id") Long id){
        allergenRepository.deleteById(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAllergen(@PathParam("id") Long id, Allergen allergen){
        allergenRepository.save(allergen);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Allergen getAllergenById(@PathParam("id") Long id){
        return allergenRepository.findById(id).orElse(null);
    }
}
